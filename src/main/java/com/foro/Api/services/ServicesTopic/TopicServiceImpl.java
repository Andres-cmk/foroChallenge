package com.foro.Api.services.ServicesTopic;

import com.foro.Api.DTO.dtoEntities.TopicDTO;
import com.foro.Api.entities.Curso;
import com.foro.Api.entities.Topico;
import com.foro.Api.entities.Usuario;
import com.foro.Api.repository.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{

    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TopicoRepository topicoRepository;

    public TopicServiceImpl(CursoRepository cursoRepository,
                            UsuarioRepository usuarioRepository, TopicoRepository topicoRepository){
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
        this.topicoRepository = topicoRepository;
    }


    @Override
    public List<Topico> findAll() {
        return topicoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        topicoRepository.deleteById(id);
    }

    @Override
    public Topico save(TopicDTO topicDTO) throws ParseException {
        Topico topico = new Topico();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        topico.setTitulo(topicDTO.titulo());
        topico.setTop_status(topicDTO.status());
        Date fecha = simpleDateFormat.parse(topicDTO.fecha());
        topico.setTop_fechaDeCreacion(fecha);

        Usuario usuario = usuarioRepository.findByCorreo(topicDTO.autor())
                .orElseThrow(() -> new IllegalArgumentException("El autor el correo ingreso no fue encontrado"));
        topico.setTop_autor(usuario);

        Curso curso = cursoRepository.findByNombre(topicDTO.curso())
                .orElseThrow(() -> new IllegalArgumentException("el nombre del curso no fue encontrado."));
        topico.setTop_curso(curso);

        return topicoRepository.save(topico);

    }
}

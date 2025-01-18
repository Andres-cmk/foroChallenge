package com.foro.Api.services.ServicesUsers;

import com.foro.Api.DTO.dtoEntities.PerfilDTO;
import com.foro.Api.DTO.dtoEntities.UsuarioDTO;
import com.foro.Api.entities.Perfil;
import com.foro.Api.entities.Usuario;
import com.foro.Api.repository.PerfilRepository;
import com.foro.Api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PerfilRepository perfilRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
    }

    @Override
    public Usuario save(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNombre(usuarioDTO.nombre());
        usuario.setCorreo(usuarioDTO.correo());
        usuario.setPassword(usuarioDTO.password());

        // mapear los perfiles

        List<Perfil> lista = usuarioDTO.perfil().stream()
                .map(this::obtenerOPersistirPerfil)
                .toList();
        usuario.setListaPerfiles(lista);

        return usuarioRepository.save(usuario);

    }

    // Obtener un perfil existente o crear uno nuevo si no existe
    private Perfil obtenerOPersistirPerfil(PerfilDTO perfilDTO) {
        return perfilRepository.findByCategoria(perfilDTO.categoria())
                .orElseGet(() -> {
                    Perfil nuevoPerfil = new Perfil();
                    nuevoPerfil.setPer_categoria(perfilDTO.categoria());
                    return perfilRepository.save(nuevoPerfil);
                });
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}

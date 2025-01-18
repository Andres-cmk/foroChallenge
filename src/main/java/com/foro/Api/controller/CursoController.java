package com.foro.Api.controller;

import com.foro.Api.DTO.dtoEntities.CursoDTO;
import com.foro.Api.entities.Curso;
import com.foro.Api.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cur")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Curso> saveCurso(@Valid @RequestBody CursoDTO cursoDTO){
        Curso curso = new Curso();
        curso.setNombre(cursoDTO.nombre());
        curso.setCur_categoria(cursoDTO.categoria());
        cursoRepository.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

}

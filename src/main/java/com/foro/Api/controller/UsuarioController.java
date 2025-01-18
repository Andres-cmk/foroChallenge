package com.foro.Api.controller;

import com.foro.Api.DTO.dtoEntities.UsuarioDTO;
import com.foro.Api.entities.Usuario;
import com.foro.Api.services.ServicesUsers.UsuarioService;
import com.foro.Api.services.ServicesUsers.UsuarioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usu")
public class UsuarioController{

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioService = usuarioServiceImpl;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Usuario> addUsuario(@RequestBody UsuarioDTO parametro) {
        Usuario usuario = usuarioService.save(parametro);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteUsuario(@PathVariable(value = "id") Long id) {
        usuarioService.delete(id);
    }

    @GetMapping(value = "/getAll")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

}

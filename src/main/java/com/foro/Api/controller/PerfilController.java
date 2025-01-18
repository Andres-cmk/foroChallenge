package com.foro.Api.controller;

import com.foro.Api.DTO.dtoEntities.PerfilDTO;
import com.foro.Api.entities.Perfil;
import com.foro.Api.services.ServicesPerfil.PerfilService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping(value = "/list")
    public List<Perfil> findAllPerfil(){
        return perfilService.findAll();
    }

    @PostMapping(value = "/addPerfil")
    public Perfil addPerfil(@Valid @RequestBody PerfilDTO perfilDTO){
        return perfilService.save(perfilDTO);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deletePerfil(@PathVariable(value = "id") @RequestBody Long id){
        perfilService.delete(id);
    }

    @PutMapping(value = "/update")
    public void updatePerfil(@Valid @RequestBody PerfilDTO perfilDTO){
        perfilService.update(perfilDTO);
    }
}

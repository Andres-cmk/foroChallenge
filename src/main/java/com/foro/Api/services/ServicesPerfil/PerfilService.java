package com.foro.Api.services.ServicesPerfil;

import com.foro.Api.DTO.dtoEntities.PerfilDTO;
import com.foro.Api.entities.Perfil;

import java.util.List;
import java.util.Optional;

public interface PerfilService {
    List<Perfil> findAll();
    Perfil save(PerfilDTO perfilDTO);
    void delete(Long idPerfil);
    Optional<Perfil> findById(Long id);
    void update(PerfilDTO perfilDTO);
}

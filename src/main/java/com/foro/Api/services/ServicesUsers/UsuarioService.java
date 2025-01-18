package com.foro.Api.services.ServicesUsers;

import com.foro.Api.DTO.dtoEntities.UsuarioDTO;
import com.foro.Api.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario save(UsuarioDTO usuario);
    void delete(Long id);
}

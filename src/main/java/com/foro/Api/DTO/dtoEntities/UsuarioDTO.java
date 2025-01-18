package com.foro.Api.DTO.dtoEntities;


import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UsuarioDTO(
        @NotBlank String nombre,
        @NotBlank String correo,
        @NotBlank String password,
        List<PerfilDTO> perfil
) {
}

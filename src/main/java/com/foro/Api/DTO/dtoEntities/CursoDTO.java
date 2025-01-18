package com.foro.Api.DTO.dtoEntities;

import jakarta.validation.constraints.NotBlank;

public record CursoDTO(
        @NotBlank(message = "Se debe proporcionar un nombre para la entidad curso") String nombre,
        @NotBlank(message = "se debe proporcionar una categoria para la entidad curso") String categoria
) {
}

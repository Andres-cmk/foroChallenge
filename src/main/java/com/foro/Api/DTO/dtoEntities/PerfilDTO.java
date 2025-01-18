package com.foro.Api.DTO.dtoEntities;

import jakarta.validation.constraints.NotBlank;

public record PerfilDTO(
        Long per_id,
        @NotBlank(message = "ingrese una categoria para el curso.") String categoria
) {
}

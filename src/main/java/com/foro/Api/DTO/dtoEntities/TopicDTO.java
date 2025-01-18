package com.foro.Api.DTO.dtoEntities;

import jakarta.validation.constraints.NotBlank;


public record TopicDTO(
        @NotBlank String titulo,
        @NotBlank String status,
        @NotBlank String autor,
        @NotBlank String curso,
        @NotBlank String fecha
        ) {
}

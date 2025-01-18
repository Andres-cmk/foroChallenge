package com.foro.Api.DTO.dtoAuthentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginUser(
        @Email String correo,
        @NotBlank String password
) {
}

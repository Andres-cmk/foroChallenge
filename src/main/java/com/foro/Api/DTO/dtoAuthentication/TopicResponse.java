package com.foro.Api.DTO.dtoAuthentication;

import java.util.Date;

public record TopicResponse(

        Long top_id,
        String titulo,
        Date fecha,
        String status,
        String respuesta,
        String autor,
        String curso
) {
}

package com.foro.Api.services;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T conversor(Object origin, Class<T> destination) {
        return mapper.convertValue(origin, destination);
    }
}

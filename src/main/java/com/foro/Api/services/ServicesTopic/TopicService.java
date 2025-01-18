package com.foro.Api.services.ServicesTopic;

import com.foro.Api.DTO.dtoEntities.TopicDTO;
import com.foro.Api.entities.Topico;

import java.text.ParseException;
import java.util.List;

public interface TopicService {
    List<Topico> findAll();
    void delete(Long id);
    Topico save(TopicDTO topicDTO) throws ParseException;
}

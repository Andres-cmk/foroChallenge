package com.foro.Api.controller;

import com.foro.Api.DTO.dtoEntities.TopicDTO;
import com.foro.Api.entities.Topico;
import com.foro.Api.services.ServicesTopic.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping( "/topic")
public class TopicoController {

    private final TopicService topicService;

    public TopicoController(TopicService topicService){
        this.topicService = topicService;
    }

    @GetMapping(value = "/findAll")
    public List<Topico> findAll(){
        return topicService.findAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Topico> save(@RequestBody TopicDTO topicDTO) throws ParseException {
        Topico topico = topicService.save(topicDTO);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping(value = "/{idTopic}/delete")
    public ResponseEntity<Topico> delete(@PathVariable(value = "idTopic") Long id) throws ParseException {
        topicService.delete(id);
        return ResponseEntity.status(200).body(null);
    }



}

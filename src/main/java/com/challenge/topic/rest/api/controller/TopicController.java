package com.challenge.topic.rest.api.controller;

import com.challenge.topic.rest.api.entity.Topic;
import com.challenge.topic.rest.api.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("topicos")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity saveTopic(@Valid @RequestBody Topic topic) throws Exception {
        try {
            topicService.saveTopic(topic);
           return ResponseEntity.ok("topico creado exitosamente");
        } catch (Exception e ){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTopic(@Valid @RequestBody Topic topic, @PathVariable("id") Integer id) throws Exception {
        try {
            Topic topicExistente = topicService.getTopic(id);
            topicExistente.setAutor(topic.getAutor());
            topicExistente.setCurso(topic.getCurso());
            topicExistente.setEstatus(topic.getEstatus());
            topicExistente.setMensaje(topic.getMensaje());
            topicExistente.setTitulo(topic.getTitulo());
            topicExistente.setFecha_creacion(topic.getFecha_creacion());
            topicService.updateTopic(topicExistente);
            return ResponseEntity.ok("topico actualizado exitosamente");
        } catch (Exception e ){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getTopicById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(topicService.getTopic(id));
    }

    @GetMapping
    public ResponseEntity getTopics() {
        return ResponseEntity.ok(topicService.getTopics());
    }

    @DeleteMapping("/{id}")
    public void deleteTopicById(@PathVariable("id") Integer id) {
        topicService.deleteTopicById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

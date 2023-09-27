package com.challenge.topic.rest.api.service;

import com.challenge.topic.rest.api.entity.Topic;
import com.challenge.topic.rest.api.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Topic getTopic(Integer id) {
        return topicRepository.getReferenceById(id);
    }

    @Override
    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }

    @Override
    public void saveTopic(Topic topic) throws Exception {
        if(topicExists(topic.getTitulo(), topic.getMensaje())){
            topicRepository.save(topic);
        } else {
            throw new Exception("no se puede guardar el topico por que mensaje y titulo ya existen en otro topico.");
        }
    }

    @Override
    public void updateTopic(Topic topic) throws Exception {
        if(topicExists(topic.getTitulo(), topic.getMensaje())){
            topicRepository.saveAndFlush(topic);
        } else {
            throw new Exception("no se puede actualizar el topico por que mensaje y titulo ya existen en otro topico.");
        }
    }

    @Override
    public void deleteTopicById(Integer topicId) {
        topicRepository.deleteById(topicId);
    }

    private Boolean topicExists(String titulo, String mensaje){
        return  topicRepository.countByTituloAndMensaje(titulo, mensaje) == 0L;
    }
}

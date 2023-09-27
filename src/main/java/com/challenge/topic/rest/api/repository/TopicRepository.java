package com.challenge.topic.rest.api.repository;

import com.challenge.topic.rest.api.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Integer> {

    long countByTituloAndMensaje(String titulo, String mensaje);
}

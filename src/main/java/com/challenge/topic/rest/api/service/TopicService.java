package com.challenge.topic.rest.api.service;

import com.challenge.topic.rest.api.entity.Topic;

import java.util.List;

public interface TopicService {

    Topic getTopic(Integer id);
    List<Topic> getTopics();
    void saveTopic(Topic topic) throws Exception;
    void updateTopic(Topic topic) throws Exception;
    void deleteTopicById(Integer topicId);
}

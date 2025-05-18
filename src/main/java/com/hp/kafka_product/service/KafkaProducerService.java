package com.hp.kafka_product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
        System.out.println("Producer Message : " + message);
    }
}

package com.hp.kafka_product.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    // Listener for group-2
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "product-group")
    public void listen(String message) {
        System.out.println("Consumed Group 1 Message : " + message);
    }

    // Listener for group-2
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "product-group-2")
    public void listenGroup2(String message) {
        System.out.println("Consumed Group 2 consumed: " + message);
    }

    // Listener for group-3
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "product-group-3")
    public void listenGroup3(String message) {
        System.out.println("Consumed Group 3 consumed: " + message);
    }
}

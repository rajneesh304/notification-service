package com.rajneesh304.notificationproducer.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message, String topicName) {
        log.info("Sending message : {}", message);
        log.info("Sending topic   : {}", topicName);
        log.info("--------------------------------");
        kafkaTemplate.send(topicName, message);
    }
}
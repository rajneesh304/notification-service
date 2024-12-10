package com.rajneesh304.notificationproducer.component;

import com.rajneesh304.notificationproducer.model.Content;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, Content> kafkaTemplate;

    public void sendMessage(Content message, String topicName) {
        log.info("Sending message : {}", message.toString());
        log.info("Sending topic   : {}", topicName);
        log.info("--------------------------------");
        kafkaTemplate.send(topicName, message);
    }
}
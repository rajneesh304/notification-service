package com.rajneesh304.notificationapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajneesh304.notificationapi.model.dtos.NotificationDto;
import com.rajneesh304.notificationapi.model.dtos.NotificationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationConsumer {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(topics = "TutorialTopic", groupId = "TutorialConsumerGroup")
    public void consumeMessage(String message) {
        try {
            // Parse the Kafka message
            ObjectMapper objectMapper = new ObjectMapper();
            NotificationRequestDto notificationRequestDTO = objectMapper.readValue(message, NotificationRequestDto.class);

            // Process the notification
            notificationService.createNotification(notificationRequestDTO);
        } catch (Exception e) {
            // Handle deserialization or processing errors
            e.printStackTrace();
        }
    }
}

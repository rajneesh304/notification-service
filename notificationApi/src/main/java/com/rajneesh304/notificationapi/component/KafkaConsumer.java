package com.rajneesh304.notificationapi.component;

import com.rajneesh304.notificationapi.channels.NotificationChannel;
import com.rajneesh304.notificationapi.model.entities.Notification;
import com.rajneesh304.notificationapi.channels.impl.EmailChannel;
import com.rajneesh304.notificationapi.service.NotificationSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "topic-2", topicPartitions = {
            @TopicPartition(topic = "topic-2", partitions = "0,1,2")
    }, containerFactory = "kafkaListenerContainerFactory")
    void listener(@Payload Notification notification,
                  @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                  @Header(KafkaHeaders.OFFSET) int offset) {
        log.info("Received message [{}] from group1, partition-{} with offset-{}", notification.toString(), partition, offset);

        List<NotificationChannel> notificationChannels = new ArrayList<>();

        notification.getChannels().stream().forEach(channel ->{
            if(channel.equals("EMAIL"))
                notificationChannels.add(new EmailChannel());
        });

        NotificationSenderService notificationSenderService = new NotificationSenderService(notificationChannels);

//        EmailChannel emailChannel = new EmailChannel();
//        emailChannel.sendNotification(notification);

        notificationSenderService.send(notification);
    }
}

package com.rajneesh304.notificationapi.service;

import com.rajneesh304.notificationapi.channels.NotificationChannel;
import com.rajneesh304.notificationapi.model.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationSenderService {
    private final List<NotificationChannel> notificationChannels;

    @Autowired
    public NotificationSenderService(List<NotificationChannel> notificationChannels) {
        this.notificationChannels = notificationChannels;
    }

    public void send(Notification notification) {
        notificationChannels.forEach(channel -> channel.sendNotification(notification));
    }
}

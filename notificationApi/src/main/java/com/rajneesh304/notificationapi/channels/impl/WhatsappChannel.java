package com.rajneesh304.notificationapi.channels.impl;

import com.rajneesh304.notificationapi.model.entities.Notification;
import com.rajneesh304.notificationapi.channels.NotificationChannel;
import org.springframework.stereotype.Component;

@Component
public class WhatsappChannel implements NotificationChannel {
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Sending WhatsApp message to " + notification.getUser().getPhoneNumber());
        // Add actual WhatsApp sending logic here
    }
}

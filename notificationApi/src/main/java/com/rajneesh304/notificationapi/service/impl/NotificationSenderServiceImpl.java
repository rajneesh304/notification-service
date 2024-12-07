package com.rajneesh304.notificationapi.service.impl;

import com.rajneesh304.notificationapi.model.entities.Notification;
import com.rajneesh304.notificationapi.service.NotificationSenderService;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderServiceImpl implements NotificationSenderService {

    @Override
    public void sendNotification(Notification notification) {
        if ("EMAIL".equals(notification.getNotificationType()) || "BOTH".equals(notification.getNotificationType())) {
            sendEmail(notification);
        }
        if ("WHATSAPP".equals(notification.getNotificationType()) || "BOTH".equals(notification.getNotificationType())) {
            sendWhatsApp(notification);
        }
    }

    private void sendEmail(Notification notification) {
        // Integrate with email provider (e.g., SES, SendGrid)
        System.out.println("Sending email: " + notification.getMessageContent());
    }

    private void sendWhatsApp(Notification notification) {
        // Integrate with WhatsApp API (e.g., Twilio)
        System.out.println("Sending WhatsApp: " + notification.getMessageContent());
    }
}

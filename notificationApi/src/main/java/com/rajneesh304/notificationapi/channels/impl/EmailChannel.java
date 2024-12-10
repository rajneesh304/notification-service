package com.rajneesh304.notificationapi.channels.impl;

import com.rajneesh304.notificationapi.config.MailSenderConfig;
import com.rajneesh304.notificationapi.model.entities.Notification;
import com.rajneesh304.notificationapi.channels.NotificationChannel;
import com.rajneesh304.notificationapi.service.util.EmailSenderServiceImpl;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailChannel implements NotificationChannel {
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Sending email to " + notification.getUser().getEmail());
        // Add actual email sending logic here
        JavaMailSender mailSender = MailSenderConfig.createJavaMailSender();
        EmailSenderServiceImpl emailSenderService = new EmailSenderServiceImpl(mailSender);
        emailSenderService.sendEmail(notification.getUser().getEmail(), "Mail from NotificationService" , notification.getMessageContent());
    }
}

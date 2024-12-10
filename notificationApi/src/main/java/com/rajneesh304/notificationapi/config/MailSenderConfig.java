package com.rajneesh304.notificationapi.config;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailSenderConfig {
    public static JavaMailSender createJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        // Set the mail server host and port
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);


        // Additional mail properties
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); // Enable this for detailed logs

        return mailSender;
    }
}

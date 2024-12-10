package com.rajneesh304.notificationapi.service.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public class EmailSenderServiceImpl {
    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String email, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom("singhatiya.rajneesh2@gmail.com", "Rajneesh Singhatiya");
            helper.setTo(email);

            helper.setSubject(subject);
            helper.setText(content, true);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (MessagingException e){
            e.printStackTrace();
        }

        mailSender.send(message);
    }
}

package com.rajneesh304.notificationapi.service;

import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface EmailSenderService {
    public void sendEmail(String email, String subject, String content);
}

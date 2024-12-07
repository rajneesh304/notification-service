package com.rajneesh304.notificationapi.model.dtos;

import java.util.List;
import java.util.UUID;

public class UserDto {
    private UUID userId;
    private String email;
    private String phoneNumber;
    private Boolean emailEnabled;
    private Boolean whatsappEnabled;
    private List<NotificationDto> notifications;

    public UserDto(UUID userId, String email, String phoneNumber, Boolean emailEnabled, Boolean whatsappEnabled, List<NotificationDto> notifications) {
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.emailEnabled = emailEnabled;
        this.whatsappEnabled = whatsappEnabled;
        this.notifications = notifications;
    }

    public UserDto() {
    }

    public UUID getUserId() {
        return this.userId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Boolean getEmailEnabled() {
        return this.emailEnabled;
    }

    public Boolean getWhatsappEnabled() {
        return this.whatsappEnabled;
    }

    public List<NotificationDto> getNotifications() {
        return this.notifications;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailEnabled(Boolean emailEnabled) {
        this.emailEnabled = emailEnabled;
    }

    public void setWhatsappEnabled(Boolean whatsappEnabled) {
        this.whatsappEnabled = whatsappEnabled;
    }

    public void setNotifications(List<NotificationDto> notifications) {
        this.notifications = notifications;
    }
}

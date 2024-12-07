package com.rajneesh304.notificationapi.service;

import com.rajneesh304.notificationapi.model.entities.Notification;

public interface NotificationSenderService {
    void sendNotification(Notification notification);
}

package com.rajneesh304.notificationapi.channels;

import com.rajneesh304.notificationapi.model.entities.Notification;

public interface NotificationChannel {
    void sendNotification(Notification notification);
}

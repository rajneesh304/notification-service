package com.rajneesh304.notificationapi.service;

import com.rajneesh304.notificationapi.model.dtos.NotificationDto;
import com.rajneesh304.notificationapi.model.dtos.NotificationRequestDto;
import com.rajneesh304.notificationapi.model.dtos.NotificationResponseDto;
import com.rajneesh304.notificationapi.model.entities.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    NotificationResponseDto createNotification(NotificationRequestDto requestDTO);
    NotificationDto getNotificationById(UUID notificationId);
    List<NotificationDto> getNotificationsByUser(UUID userId);
}

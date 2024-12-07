package com.rajneesh304.notificationapi.controller;

import com.rajneesh304.notificationapi.model.dtos.NotificationDto;
import com.rajneesh304.notificationapi.model.dtos.NotificationRequestDto;
import com.rajneesh304.notificationapi.model.dtos.NotificationResponseDto;
import com.rajneesh304.notificationapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationResponseDto> createNotification(
            @RequestBody NotificationRequestDto notificationRequestDTO) {
        NotificationResponseDto response = notificationService.createNotification(notificationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationDto> getNotification(@PathVariable UUID notificationId) {
        NotificationDto notification = notificationService.getNotificationById(notificationId);
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationDto>> getNotificationsByUser(@PathVariable UUID userId) {
        List<NotificationDto> notifications = notificationService.getNotificationsByUser(userId);
        return ResponseEntity.ok(notifications);
    }
}

package com.rajneesh304.notificationapi.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponseDto {
    private UUID notificationId;
    private UUID userId;
    private String notificationType;
    private String status; // SUCCESS, FAILURE
    private String message;

}

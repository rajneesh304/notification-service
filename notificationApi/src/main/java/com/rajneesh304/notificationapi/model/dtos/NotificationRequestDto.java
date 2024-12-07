package com.rajneesh304.notificationapi.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequestDto {
    private UUID userId;
    private String notificationType; // EMAIL, WHATSAPP, BOTH
    private String messageContent;

    // Optional for EMAIL
    private String emailSubject;
}

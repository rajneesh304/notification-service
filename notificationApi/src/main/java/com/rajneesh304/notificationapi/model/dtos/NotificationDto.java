package com.rajneesh304.notificationapi.model.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private UUID notificationId;
    private String notificationType;
    private String status;
    private String messageContent;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
    private List<ChannelDetailDto> channelDetails;

}

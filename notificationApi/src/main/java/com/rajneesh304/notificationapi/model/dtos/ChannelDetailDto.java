package com.rajneesh304.notificationapi.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDetailDto {
    private String channelType;
    private String emailSubject;
    private String whatsappMessageId;
    private String status;
    private String errorDetails;
}

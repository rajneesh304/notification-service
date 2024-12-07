package com.rajneesh304.notificationapi.service.impl;

import com.rajneesh304.notificationapi.model.dtos.NotificationDto;
import com.rajneesh304.notificationapi.model.dtos.NotificationRequestDto;
import com.rajneesh304.notificationapi.model.dtos.NotificationResponseDto;
import com.rajneesh304.notificationapi.model.entities.ChannelDetail;
import com.rajneesh304.notificationapi.model.entities.Notification;
import com.rajneesh304.notificationapi.model.entities.User;
import com.rajneesh304.notificationapi.repository.ChannelDetailRepository;
import com.rajneesh304.notificationapi.repository.NotificationRepository;
import com.rajneesh304.notificationapi.repository.UserRepository;
import com.rajneesh304.notificationapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelDetailRepository channelDetailRepository;

    @Override
    public NotificationResponseDto createNotification(NotificationRequestDto requestDTO) {
        // Fetch the user from the repository
        User user = userRepository.findByUserId(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create a new Notification entity
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setNotificationType(requestDTO.getNotificationType());
        notification.setMessageContent(requestDTO.getMessageContent());
        notification.setStatus("PENDING");
        notification.setCreatedAt(LocalDateTime.now());

        // Save the notification to the database
        Notification savedNotification = notificationRepository.save(notification);

        // Process the notification to send to different channels
        sendNotificationToChannels(savedNotification);

        // Return a response DTO
        return mapToResponseDTO(savedNotification);
    }

    @Override
    public List<NotificationDto> getNotificationsByUser(UUID userId) {
        // Retrieve notifications for a specific user
        List<Notification> notifications = notificationRepository.findByUserUserId(userId);
        return notifications.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private void sendNotificationToChannels(Notification notification) {
        // Example logic to send notification to different channels
        // This would typically involve calling external services for email/WhatsApp
        List<ChannelDetail> channelDetails = new ArrayList<>();

        if (notification.getUser().getEmailEnabled()) {
            channelDetails.add(createChannelDetail(notification, "EMAIL"));
            // Call your email service here (e.g., sendEmail(notification))
        }

        if (notification.getUser().getWhatsappEnabled()) {
            channelDetails.add(createChannelDetail(notification, "WHATSAPP"));
            // Call your WhatsApp service here (e.g., sendWhatsapp(notification))
        }

        // Save channel details to the database
        channelDetailRepository.saveAll(channelDetails);

        // Update notification status to SENT after sending to channels
        notification.setStatus("SENT");
        notification.setSentAt(LocalDateTime.now());
        notificationRepository.save(notification);
    }

    private ChannelDetail createChannelDetail(Notification notification, String channelType) {
        ChannelDetail channelDetail = new ChannelDetail();
        channelDetail.setNotification(notification);
        channelDetail.setChannelType(channelType);
        channelDetail.setStatus("PENDING"); // Initially pending
        return channelDetail;
    }

    private NotificationResponseDto mapToResponseDTO(Notification notification) {
        NotificationResponseDto dto = new NotificationResponseDto();
        dto.setNotificationId(notification.getId());
        dto.setUserId(notification.getUser().getUserId());
        dto.setNotificationType(notification.getNotificationType());
        dto.setStatus(notification.getStatus());
        dto.setMessage("Notification created successfully");
        return dto;
    }

    private NotificationDto mapToDTO(Notification notification) {
        NotificationDto dto = new NotificationDto();
        dto.setNotificationId(notification.getId());
        dto.setNotificationType(notification.getNotificationType());
        dto.setStatus(notification.getStatus());
        dto.setMessageContent(notification.getMessageContent());
        dto.setCreatedAt(notification.getCreatedAt());
        dto.setSentAt(notification.getSentAt());
        return dto;
    }

    @Override
    public NotificationDto getNotificationById(UUID notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        // Convert the Notification entity to NotificationDTO and return it
        return mapToDTO(notification);
    }
}

package com.rajneesh304.notificationapi.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "channel_detail")
public class ChannelDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id", nullable = false)
    private Notification notification;

    @Column(nullable = false)
    private String channelType; // EMAIL, WHATSAPP

    private String emailSubject; // Used for EMAIL channel

    private String whatsappMessageId; // Twilio or provider-specific message ID

    @Column(nullable = false)
    private String status; // PENDING, SENT, FAILED

    private String errorDetails;
}

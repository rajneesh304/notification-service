package com.rajneesh304.notificationapi.model.entities;

import com.rajneesh304.notificationapi.enums.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String messageContent;

    @Column
    private String status; // PENDING, SENT, FAILED

    @Column
    private LocalDateTime sentAt;

    @ElementCollection
    private Set<String> channels; // EMAIL, WHATSAPP, etc.
}

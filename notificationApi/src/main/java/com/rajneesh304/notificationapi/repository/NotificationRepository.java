package com.rajneesh304.notificationapi.repository;

import com.rajneesh304.notificationapi.model.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    List<Notification> findByUserUserId(UUID userId);  // Custom query to find notifications by userId
}

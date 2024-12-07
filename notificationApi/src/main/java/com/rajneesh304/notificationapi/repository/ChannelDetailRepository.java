package com.rajneesh304.notificationapi.repository;

import com.rajneesh304.notificationapi.model.entities.ChannelDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChannelDetailRepository extends JpaRepository<ChannelDetail, UUID> {
    List<ChannelDetail> findByNotificationId(UUID notificationId);  // Custom query to find channel details by notificationId
}

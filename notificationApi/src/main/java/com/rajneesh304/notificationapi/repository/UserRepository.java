package com.rajneesh304.notificationapi.repository;

import com.rajneesh304.notificationapi.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
//    Optional<User> findByUserId(UUID userId);  // Custom query to find by userId
}
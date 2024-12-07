package com.rajneesh304.notificationapi.service;

import com.rajneesh304.notificationapi.model.dtos.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDTO);
    UserDto getUserById(UUID userId);
    UserDto updateUserPreferences(UUID userId, UserDto userDTO);
    List<UserDto> getAllUsers();
}

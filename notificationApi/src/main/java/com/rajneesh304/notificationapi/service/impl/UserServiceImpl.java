package com.rajneesh304.notificationapi.service.impl;

import com.rajneesh304.notificationapi.model.dtos.UserDto;
import com.rajneesh304.notificationapi.model.entities.User;
import com.rajneesh304.notificationapi.repository.UserRepository;
import com.rajneesh304.notificationapi.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmailEnabled(userDTO.getEmailEnabled());
        user.setWhatsappEnabled(userDTO.getWhatsappEnabled());

        User savedUser = userRepository.save(user);
        return mapToDto(savedUser);
    }

    @Override
    public UserDto getUserById(UUID userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDto(user);
    }

    @Override
    public UserDto updateUserPreferences(UUID userId, UserDto userDTO) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setEmailEnabled(userDTO.getEmailEnabled());
        user.setWhatsappEnabled(userDTO.getWhatsappEnabled());
        User updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private UserDto mapToDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setEmailEnabled(user.getEmailEnabled());
        dto.setWhatsappEnabled(user.getWhatsappEnabled());
        return dto;
    }
}

package com.rajneesh304.notificationapi.controller;

import com.rajneesh304.notificationapi.config.MailSenderConfig;
import com.rajneesh304.notificationapi.model.dtos.UserDto;
import com.rajneesh304.notificationapi.service.UserService;
import com.rajneesh304.notificationapi.service.impl.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDTO) {
        UserDto createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID userId) {
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUserPreferences(
            @PathVariable UUID userId,
            @RequestBody UserDto userDTO) {
        UserDto updatedUser = userService.updateUserPreferences(userId, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /*
    Test notification - SUCCEEDED
     */
//    @GetMapping("/service")
//    public void trigger () {
//        JavaMailSender mailSender = MailSenderConfig.createJavaMailSender();
//        EmailSenderServiceImpl emailSenderService = new EmailSenderServiceImpl(mailSender);
//        emailSenderService.sendEmail("singhatiya.rajneesh2@gmail.com", "Test", "This is a test mail");
//    }
}

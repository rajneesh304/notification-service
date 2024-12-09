package com.rajneesh304.notificationproducer.controller;

import com.rajneesh304.notificationproducer.component.KafkaSender;
import com.rajneesh304.notificationproducer.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class Producer {
    @Autowired
    KafkaSender kafkaSender;
    @PostMapping
    public void sendMessage(@RequestBody Content content) {
        kafkaSender.sendMessage(content.getMessage(), "topic-2");
    }
}

package com.zilen.messagingservice.controller;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody Message message) {
        messageService.send(message);
    }
}

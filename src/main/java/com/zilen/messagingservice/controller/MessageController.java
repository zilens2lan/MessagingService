package com.zilen.messagingservice.controller;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public void send() {
        messageService.send();
    }

    @PostMapping("/createMessage")
    @ResponseStatus(HttpStatus.OK)
    public void createMessage() {
        messageService.createMessage();
    }
}

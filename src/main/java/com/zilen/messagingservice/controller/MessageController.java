package com.zilen.messagingservice.controller;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.service.MessageRedirectingService;
import com.zilen.messagingservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {

    private final MessageRedirectingService messageRedirectingService;
    private final MessageService messageService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> findByUserName(@RequestParam(value = "userName", required = false) String userName) {
        return messageService.findByUserName(userName);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMessage(@PathVariable UUID id) {
        messageService.deleteMessage(id);
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody Message message) {
        messageRedirectingService.redirect(message);
    }
}
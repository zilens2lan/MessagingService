package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRedirectingService messageRedirectingService;

    public void send(Message message) {
        messageRedirectingService.redirect(message);
    }
}

package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;

public class EmailSender implements ChannelSender {

    @Override
    public void send(Message message) {
        System.out.println(message.toString()+"message send to Email");
    }
}

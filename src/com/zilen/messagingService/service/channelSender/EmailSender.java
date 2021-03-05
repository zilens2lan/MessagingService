package com.zilen.messagingService.service.channelSender;

import com.zilen.messagingService.entity.Message;

public class EmailSender implements ChannelSender {

    @Override
    public void send(Message message) {
        System.out.println("message send to Email: " + message.toString());
    }
}

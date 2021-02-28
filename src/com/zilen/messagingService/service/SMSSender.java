package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;

public class SMSSender implements ChannelSender {

    @Override
    public void send(Message message) {
        Message messageFiltered = Message.builder()
                .id(message.getId())
                .sender(message.getSender())
                .text(message.getText())
                .date(message.getDate())
                .attachments(null)
                .build();

        System.out.println(messageFiltered.toString() + "message send to SMS");
    }
}

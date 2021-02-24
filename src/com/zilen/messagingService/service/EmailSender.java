package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;

public class EmailSender implements ChannelSender {

    @Override
    public void sendFiltering(Message message) {
        Message messageFiltered = Message.builder()
                .id(message.getId())
                .sender(message.getSender())
                .text(message.getText())
                .date(message.getDate())
                .attachmentList(message.getAttachmentList())
                .build();

        System.out.println(messageFiltered.toString()+"message send to Email");
    }
}

package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.attachment.Attachment;

public class SMSSender implements ChannelSender {

    @Override
    public void sendFiltering(Message message) {
        Message messageFiltered = Message.builder()
                .id(message.getId())
                .sender(message.getSender())
                .text(message.getText())
                .date(message.getDate())
                .attachmentList(null)
                .build();

        System.out.println(messageFiltered.toString() + "message send to SMS");
    }
}

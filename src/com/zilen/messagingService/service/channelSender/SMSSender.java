package com.zilen.messagingService.service.channelSender;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Email;
import com.zilen.messagingService.entity.channel.Facebook;
import com.zilen.messagingService.entity.channel.SMS;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SMSSender implements ChannelSender {

    @Override
    public void send(Message message) {
        Message messageFiltered = Message.builder()
                .id(message.getId())
                .sender(message.getSender())
                .text(message.getText())
                .dateTime(message.getDateTime())
                .attachments(null)
                .build();

        System.out.println("message send to SMS: " + messageFiltered.toString());
    }
}

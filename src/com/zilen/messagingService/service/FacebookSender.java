package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.attachment.Attachment;
import com.zilen.messagingService.entity.attachment.Document;
import com.zilen.messagingService.entity.attachment.Picture;

import java.util.List;
import java.util.stream.Collectors;

public class FacebookSender implements ChannelSender {

    @Override
    public void send(Message message) {
        List<Class<? extends Attachment>> supportedAttachments = List.of(Document.class, Picture.class);

        Message messageFiltered = Message.builder()
                .id(message.getId())
                .sender(message.getText())
                .text(message.getText())
                .dateTime(message.getDateTime())
                .attachments(message.getAttachments()
                        .stream()
                        .filter(attachment -> supportedAttachments.contains(attachment.getClass()))
                        .collect(Collectors.toList()))
                .build();

        System.out.println(messageFiltered.toString() + "message facebook");
    }
}

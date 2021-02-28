package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.attachment.Attachment;
import com.zilen.messagingService.entity.attachment.Document;
import com.zilen.messagingService.entity.attachment.Picture;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FacebookSender implements ChannelSender {

    @Override
    public void send(Message message) {
        List<Class<? extends Attachment>> supportedAttachments = List.of(Document.class, Picture.class);

        List<Attachment> attachments = new ArrayList<>();
        for(Attachment attachment : message.getAttachments()){
            if(supportedAttachments.contains(attachment.getClass())){
                attachments.add(attachment);
            }
        }

        Message messageFiltered = Message.builder()
                .id(message.getId())
                .sender(message.getText())
                .text(message.getText())
                .date(message.getDate())
                .attachments(attachments)
                .build();

        System.out.println(messageFiltered.toString() + "message facebook");
    }
}

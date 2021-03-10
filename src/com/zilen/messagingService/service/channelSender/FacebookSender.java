package com.zilen.messagingService.service.channelSender;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.attachment.Attachment;
import com.zilen.messagingService.entity.attachment.Document;
import com.zilen.messagingService.entity.attachment.Picture;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Facebook;

import java.util.List;
import java.util.stream.Collectors;

public class FacebookSender implements ChannelSender {

    @Override
    public void send(Message message, Channel channel) {
        List<Class<? extends Attachment>> supportedAttachments = List.of(Document.class, Picture.class);

        Message messageFiltered = Message.builder()
                .id(message.getId())
                .sender(message.getSender())
                .text(message.getText())
                .dateTime(message.getDateTime())
                .attachments(message.getAttachments()
                        .stream()
                        .filter(attachment -> supportedAttachments.contains(attachment.getClass()))
                        .collect(Collectors.toList()))
                .build();

        System.out.println("message send to Facebook: " + messageFiltered.toString());

        if (!channel.getSender().equals(message.getSender())) {
            throw new IllegalStateException("facebook: sender is empty!");
        }

        try {
            Facebook facebook = ((Facebook) channel);
            System.out.println("facebook: sent from " + facebook.getFromFacebookId() + "to" + facebook.getToFacebookId());
        }catch (ClassCastException ex){}
    }

}

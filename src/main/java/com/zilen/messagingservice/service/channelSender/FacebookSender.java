package com.zilen.messagingservice.service.channelSender;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.attachment.Attachment;
import com.zilen.messagingservice.entity.attachment.Document;
import com.zilen.messagingservice.entity.attachment.Picture;
import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.entity.channel.Facebook;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class FacebookSender implements ChannelSender {

    private static final List<Class<? extends Attachment>> supportedAttachments = List.of(Document.class, Picture.class);

    @Override
    public void send(Message message, Channel channel) {
        assertTrue(channel instanceof Facebook, "Channel type does not match 'Facebook' !!!");
        Facebook facebook = ((Facebook) channel);

        Message messageFiltered = Message.builder()
                .id(message.getId())
                .userName(message.getUserName())
                .text(message.getText())
                .dateTime(message.getDateTime())
                .attachments(message.getAttachments()
                        .stream()
                        .filter(attachment -> supportedAttachments.contains(attachment.getClass()))
                        .collect(Collectors.toList()))
                .build();

        System.out.println("message send to Facebook: " + messageFiltered.toString());
        System.out.println("facebook: sent from " + facebook.getFromFacebookId() + " to " + facebook.getToFacebookId());
    }

    @Override
    public boolean supports(Channel channel) {
        return channel instanceof Facebook;
    }
}

package com.zilen.messagingservice;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.attachment.Audio;
import com.zilen.messagingservice.entity.attachment.Document;
import com.zilen.messagingservice.entity.attachment.Picture;
import com.zilen.messagingservice.entity.channel.Facebook;
import com.zilen.messagingservice.service.MessageRedirectingService;
import com.zilen.messagingservice.service.UserService;
import com.zilen.messagingservice.service.channelSender.EmailSender;
import com.zilen.messagingservice.service.channelSender.FacebookSender;
import com.zilen.messagingservice.service.channelSender.SMSSender;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MessagingServiceApplication {

    public static void main(String[] args) {
        System.out.println("start");

        Document document = Document.builder()
                .id(UUID.randomUUID())
                .title("document")
                .format("doc")
                .size(Byte.MAX_VALUE)
                .build();
        Picture picture = Picture.builder()
                .id(UUID.randomUUID())
                .title("picture")
                .format("png")
                .height(1080)
                .width(1920)
                .build();
        Audio audio = Audio.builder()
                .id(UUID.randomUUID())
                .title("audio")
                .format("mp3")
                .duration(Duration.ofSeconds(364))
                .build();

        Message message = Message.builder()
                .id(UUID.randomUUID())
                .userName("Zilen")
                .text("Text Text Text")
                .dateTime(LocalDateTime.now())
                .attachments(List.of(document, picture, audio))
                .build();

        System.out.println("message: " + message.toString());

        EmailSender emailSender = new EmailSender();
        FacebookSender facebookSender = new FacebookSender();
        SMSSender smsSender = new SMSSender();

        UserService userService = new UserService();
        MessageRedirectingService messageRedirectingService = new MessageRedirectingService(List.of(smsSender, emailSender, facebookSender), userService);
        messageRedirectingService.redirect(message);

    }
}

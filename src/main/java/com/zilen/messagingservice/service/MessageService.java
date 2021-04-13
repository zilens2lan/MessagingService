package com.zilen.messagingservice.service;

import com.zilen.messagingservice.config.MessageRedirectingServiceConfig;
import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.attachment.Audio;
import com.zilen.messagingservice.entity.attachment.Document;
import com.zilen.messagingservice.entity.attachment.Picture;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    public void send() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageRedirectingServiceConfig.class);
        MessageRedirectingService messageRedirectingService = context.getBean(MessageRedirectingService.class);
        messageRedirectingService.redirect(createMessage());
    }

    public Message createMessage() {
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

        return Message.builder()
                .id(UUID.randomUUID())
                .userName("Zilen")
                .text("Text Text Text")
                .dateTime(LocalDateTime.now())
                .attachments(List.of(document, picture, audio))
                .build();
    }
}

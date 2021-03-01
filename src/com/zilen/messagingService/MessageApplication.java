package com.zilen.messagingService;


import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.attachment.Audio;
import com.zilen.messagingService.entity.attachment.Document;
import com.zilen.messagingService.entity.attachment.Picture;
import com.zilen.messagingService.service.EmailSender;
import com.zilen.messagingService.service.FacebookSender;
import com.zilen.messagingService.service.SMSSender;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MessageApplication {

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
                .sender("Zilen")
                .text("Text Text Text")
                .date(LocalDate.now())
                .attachments(List.of(document, picture, audio))
                .build();

        System.out.println(message.toString() + "message");

        SMSSender sendSMS = new SMSSender();
        FacebookSender sendFacebook = new FacebookSender();
        EmailSender sendEmail = new EmailSender();

        sendSMS.send(message);
        sendFacebook.send(message);
        sendEmail.send(message);
    }
}

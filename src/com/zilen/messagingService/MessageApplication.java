package com.zilen.messagingService;


import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.attachment.Attachment;
import com.zilen.messagingService.entity.attachment.Audio;
import com.zilen.messagingService.entity.attachment.Document;
import com.zilen.messagingService.entity.attachment.Picture;
import com.zilen.messagingService.service.EmailSender;
import com.zilen.messagingService.service.FacebookSender;
import com.zilen.messagingService.service.SMSSender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MessageApplication {

    public static void main(String[] args) {
        System.out.println("start");

        Date date = new Date();
        Message messageFiltered = Message.builder()
                .id(UUID.randomUUID())
                .sender("Zilen")
                .text("Text Text Text")
                .date(date)
                .attachmentList(null)
                .build();
        Document document = Document.builder()
                .id(UUID.randomUUID())
                .title("document")
                .format("doc")
                .build();
        Picture picture = Picture.builder()
                .id(UUID.randomUUID())
                .title("picture")
                .format("png")
                .build();
        Audio audio = Audio.builder()
                .id(UUID.randomUUID())
                .title("audio")
                .format("mp3")
                .build();

        List<Attachment> attachmentList = new ArrayList<>();
        attachmentList.add(document);
        attachmentList.add(audio);
        attachmentList.add(picture);
        messageFiltered.setAttachmentList(attachmentList);

        System.out.println(messageFiltered.toString() + "message");

        SMSSender sendSMS = new SMSSender();
        sendSMS.sendFiltering(messageFiltered);

        EmailSender sendEmail = new EmailSender();
        sendEmail.sendFiltering(messageFiltered);

        FacebookSender sendFacebook = new FacebookSender();
        sendFacebook.sendFiltering(messageFiltered);
    }
}

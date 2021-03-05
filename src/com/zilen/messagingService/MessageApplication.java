package com.zilen.messagingService;


import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.attachment.Audio;
import com.zilen.messagingService.entity.attachment.Document;
import com.zilen.messagingService.entity.attachment.Picture;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Email;
import com.zilen.messagingService.entity.channel.Facebook;
import com.zilen.messagingService.entity.channel.SMS;
import com.zilen.messagingService.service.channelConfig.EmailConfig;
import com.zilen.messagingService.service.channelConfig.FacebookConfig;
import com.zilen.messagingService.service.channelConfig.SMSConfig;
import com.zilen.messagingService.service.channelSender.EmailSender;
import com.zilen.messagingService.service.channelSender.FacebookSender;
import com.zilen.messagingService.service.channelSender.SMSSender;

import java.time.Duration;
import java.time.LocalDateTime;
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
                .dateTime(LocalDateTime.now())
                .attachments(List.of(document, picture, audio))
                .build();

        SMS sms1 = SMS.builder()
                .id(UUID.randomUUID())
                .sender("Zilen")
                .from("375297195905")
                .to("375295942824")
                .build();
        SMS sms3 = SMS.builder()
                .id(UUID.randomUUID())
                .sender("Zilen")
                .from("375295979644")
                .to("375295942828")
                .build();
        SMS sms2 = SMS.builder()
                .id(UUID.randomUUID())
                .sender("Ripok")
                .from("375295941828")
                .to("375295942825")
                .build();
        Email email = Email.builder()
                .id(UUID.randomUUID())
                .sender("Ripok")
                .from("ZilenS2Lan@mail.ru")
                .to("zilens2lan@gmail.com")
                .build();
        Facebook facebook = Facebook.builder()
                .id(UUID.randomUUID())
                .sender("Zilen")
                .from("@id_zilen")
                .to("@id_facebook")
                .build();

        List<Channel> channels = List.of(sms1, sms2, sms3, facebook, email);


        System.out.println("message: "+ message.toString());

        SMSSender sendSMS = new SMSSender();
        FacebookSender sendFacebook = new FacebookSender();
        EmailSender sendEmail = new EmailSender();

        sendSMS.send(message);
        sendFacebook.send(message);
        sendEmail.send(message);

        SMSConfig smsConfig = new SMSConfig();
        EmailConfig emailConfig = new EmailConfig();
        FacebookConfig facebookConfig = new FacebookConfig();

        smsConfig.sendConfig(message.getSender(), channels);
        emailConfig.sendConfig(message.getSender(), channels);
        facebookConfig.sendConfig(message.getSender(), channels);
        facebookConfig.sendConfig("Rip4ok", channels);
    }
}

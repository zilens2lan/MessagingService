package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Email;
import com.zilen.messagingService.entity.channel.Facebook;
import com.zilen.messagingService.entity.channel.SMS;
import com.zilen.messagingService.service.channelSender.EmailSender;
import com.zilen.messagingService.service.channelSender.FacebookSender;
import com.zilen.messagingService.service.channelSender.SMSSender;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MessageRedirectingService {

    public void redirect(Message message) {
        System.out.println("redirect");

        SMS sms1 = SMS.builder()
                .id(UUID.randomUUID())
                .sender("Zilen")
                .fromPhoneNumber("375297195905")
                .toPhoneNumber("375295942824")
                .build();
        SMS sms3 = SMS.builder()
                .id(UUID.randomUUID())
                .sender("Zilen")
                .fromPhoneNumber("375295979644")
                .toPhoneNumber("375295942828")
                .build();
        SMS sms2 = SMS.builder()
                .id(UUID.randomUUID())
                .sender("Ripok")
                .fromPhoneNumber("375295941828")
                .toPhoneNumber("375295942825")
                .build();
        Email email = Email.builder()
                .id(UUID.randomUUID())
                .sender("Zilen")
                .fromEmailAddress("ZilenS2Lan@mail.ru")
                .toEmailAddress("zilens2lan@gmail.com")
                .build();
        Facebook facebook = Facebook.builder()
                .id(UUID.randomUUID())
                .sender("Zilen")
                .fromFacebookId("@id_zilen")
                .toFacebookId("@id_facebook")
                .build();

        System.out.println("message: " + message.toString());

        SMSSender sendSMS = new SMSSender();
        FacebookSender sendFacebook = new FacebookSender();
        EmailSender sendEmail = new EmailSender();

        sendFacebook.send(message, facebook);
        sendFacebook.send(message, sms1);
        sendEmail.send(message, email);
        sendSMS.send(message, sms1);
        sendSMS.send(message, sms2);
        sendSMS.send(message, sms3);
    }
}

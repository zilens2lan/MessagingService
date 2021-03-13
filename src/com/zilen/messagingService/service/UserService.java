package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Email;
import com.zilen.messagingService.entity.channel.Facebook;
import com.zilen.messagingService.entity.channel.SMS;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {

    public List<Channel> getUserChannels(String userName) {
        SMS sms1 = SMS.builder()
                .id(UUID.randomUUID())
                .userName("Zilen")
                .fromPhoneNumber("375297195905")
                .toPhoneNumber("375295942824")
                .build();
        SMS sms3 = SMS.builder()
                .id(UUID.randomUUID())
                .userName("Zilen")
                .fromPhoneNumber("375295979644")
                .toPhoneNumber("375295942828")
                .build();
        SMS sms2 = SMS.builder()
                .id(UUID.randomUUID())
                .userName("Ripok")
                .fromPhoneNumber("375295941828")
                .toPhoneNumber("375295942825")
                .build();
        Email email = Email.builder()
                .id(UUID.randomUUID())
                .userName("Ripok")
                .fromEmailAddress("ZilenS2Lan@mail.ru")
                .toEmailAddress("zilens2lan@gmail.com")
                .build();
        Facebook facebook = Facebook.builder()
                .id(UUID.randomUUID())
                .userName("Zilen")
                .fromFacebookId("@id_zilen")
                .toFacebookId("@id_facebook")
                .build();

        List<Channel> channels = List.of(sms1, sms2, sms3, email, facebook).stream().filter(channel -> channel.getUserName().equals(userName)).collect(Collectors.toList());
        if (channels.isEmpty()) {
            throw new IllegalStateException("Such User has no channels");
        }
        return channels;
    }
}

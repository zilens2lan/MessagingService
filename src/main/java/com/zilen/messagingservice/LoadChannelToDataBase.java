package com.zilen.messagingservice;

import com.zilen.messagingservice.entity.channel.Email;
import com.zilen.messagingservice.entity.channel.Facebook;
import com.zilen.messagingservice.entity.channel.SMS;
import com.zilen.messagingservice.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoadChannelToDataBase {

    private final ChannelRepository channelRepository;

    @PostConstruct
    public void initChannelDataBase() {
        channelRepository.deleteAll();
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
        channelRepository.saveAll(List.of(sms1, sms2, sms3, email, facebook));
    }
}

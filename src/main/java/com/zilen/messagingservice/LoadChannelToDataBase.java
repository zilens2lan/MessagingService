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

        SMS sms1 = new SMS(UUID.randomUUID(), "Zilen", "375297195905", "375295942824");
        SMS sms2 = new SMS(UUID.randomUUID(), "Zilen", "3755901114", "375295979644");
        SMS sms3 = new SMS(UUID.randomUUID(), "Ripok", "37529719595", "375295971114");
        Email email = new Email(UUID.randomUUID(), "Ripok", "zilens2lan@gmail.com", "zilencompany@mail.ru");
        Facebook facebook = new Facebook(UUID.randomUUID(), "Zilen", "@id_facebook", "@id_Zilen");
        channelRepository.saveAll(List.of(sms1, sms2, sms3, email, facebook));
    }
}

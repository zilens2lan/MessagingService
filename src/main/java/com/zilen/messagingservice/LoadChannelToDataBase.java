package com.zilen.messagingservice;

import com.zilen.messagingservice.entity.channel.Email;
import com.zilen.messagingservice.entity.channel.Facebook;
import com.zilen.messagingservice.entity.channel.SMS;
import com.zilen.messagingservice.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class LoadChannelToDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadChannelToDataBase.class);

    @Bean
    CommandLineRunner initChannelDataBase(ChannelRepository channelRepository){
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

        return args -> {
            log.info("Preloading " +channelRepository.save(sms1));
            log.info("Preloading " +channelRepository.save(sms2));
            log.info("Preloading " +channelRepository.save(sms3));
            log.info("Preloading " +channelRepository.save(email));
            log.info("Preloading " +channelRepository.save(facebook));
        };
    }
}

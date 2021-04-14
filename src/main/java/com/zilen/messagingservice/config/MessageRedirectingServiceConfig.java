package com.zilen.messagingservice.config;

import com.zilen.messagingservice.service.channelSender.ChannelSender;
import com.zilen.messagingservice.service.channelSender.EmailSender;
import com.zilen.messagingservice.service.channelSender.FacebookSender;
import com.zilen.messagingservice.service.channelSender.SMSSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MessageRedirectingServiceConfig {

    @Bean
    public List<ChannelSender> channelSenders() {
        EmailSender emailSender = new EmailSender();
        FacebookSender facebookSender = new FacebookSender();
        SMSSender smsSender = new SMSSender();
        return List.of(emailSender, facebookSender, smsSender);
    }
}

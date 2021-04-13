package com.zilen.messagingservice.config;

import com.zilen.messagingservice.repository.ChannelRepository;
import com.zilen.messagingservice.service.MessageRedirectingService;
import com.zilen.messagingservice.service.UserService;
import com.zilen.messagingservice.service.channelSender.ChannelSender;
import com.zilen.messagingservice.service.channelSender.EmailSender;
import com.zilen.messagingservice.service.channelSender.FacebookSender;
import com.zilen.messagingservice.service.channelSender.SMSSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MessageRedirectingServiceConfig {

    private final ChannelRepository channelRepository;

    @Bean
    public MessageRedirectingService redirect(){
        EmailSender emailSender = new EmailSender();
        FacebookSender facebookSender = new FacebookSender();
        SMSSender smsSender = new SMSSender();
        return new MessageRedirectingService(List.of(emailSender, facebookSender, smsSender), new UserService(channelRepository));
    }
}

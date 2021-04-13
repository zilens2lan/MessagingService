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
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.List;

@Configuration
public class MessageRedirectingServiceConfig {

    @Autowired
    private ChannelRepository channelRepository;

    @Bean
    public List<ChannelSender> channelSenders(){
        EmailSender emailSender = new EmailSender();
        FacebookSender facebookSender = new FacebookSender();
        SMSSender smsSender = new SMSSender();
        return List.of(emailSender, facebookSender, smsSender);
    }

    @Bean
    public UserService getUserService(){
        return new UserService(channelRepository);
    }

    @Bean
    public MessageRedirectingService getBean(){
        return new MessageRedirectingService(channelSenders(), getUserService());
    }
}

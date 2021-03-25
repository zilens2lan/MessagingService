package com.zilen.messagingservice;

import com.zilen.messagingservice.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableMongoRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@ComponentScan
public class MessagingServiceApplication implements CommandLineRunner {

    @Autowired
    private ChannelRepository channelRepository;

    public static void main(String[] args) {
        SpringApplication.run(MessagingServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        channelRepository.deleteAll();
    }
}

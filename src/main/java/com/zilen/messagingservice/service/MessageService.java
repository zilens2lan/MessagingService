package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.repository.ChannelRepository;
import com.zilen.messagingservice.service.channelSender.EmailSender;
import com.zilen.messagingservice.service.channelSender.FacebookSender;
import com.zilen.messagingservice.service.channelSender.SMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private ChannelRepository channelRepository;

    public void send(Message message) {
        EmailSender emailSender = new EmailSender();
        FacebookSender facebookSender = new FacebookSender();
        SMSSender smsSender = new SMSSender();

        UserService userService = new UserService(channelRepository);
        MessageRedirectingService messageRedirectingService = new MessageRedirectingService(List.of(smsSender, emailSender, facebookSender), userService);

        messageRedirectingService.redirect(message);
    }
}

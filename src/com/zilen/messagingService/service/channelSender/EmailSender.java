package com.zilen.messagingService.service.channelSender;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Email;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailSender implements ChannelSender {

    @Override
    public void send(Message message, Channel channel) {
        assertTrue(channel instanceof Email, "WRONG TYPE!!!");
        Email email = ((Email) channel);

        System.out.println("message send to Email: " + message.toString());
        System.out.println("email: sent from " + email.getFromEmailAddress() + " to " + email.getToEmailAddress());
    }
}

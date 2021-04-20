package com.zilen.messagingservice.service.channelSender;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.entity.channel.Email;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class EmailSender implements ChannelSender {

    @Override
    public void send(Message message, Channel channel) {
        assertTrue(channel instanceof Email, "Channel type does not match 'Email' !!!");
        Email email = ((Email) channel);

        System.out.println("message send to Email: " + message.toString());
        System.out.println("email: sent from " + email.getFromEmailAddress() + " to " + email.getToEmailAddress());
    }

    @Override
    public boolean supports(Channel channel) {
        return channel instanceof Email;
    }
}

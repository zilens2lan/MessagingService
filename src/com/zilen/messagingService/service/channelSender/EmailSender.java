package com.zilen.messagingService.service.channelSender;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Email;

public class EmailSender implements ChannelSender {

    @Override
    public void send(Message message, Channel channel) {
        System.out.println("message send to Email: " + message.toString());

        if (!channel.getSender().equals(message.getSender())) {
            throw new IllegalStateException("email: sender is empty!");
        }

        try {
            Email email = ((Email) channel);
            System.out.println("facebook: sent from " + email.getFromEmailAddress() + "to" + email.getToEmailAddress());
        } catch (ClassCastException ex) {
        }
    }
}

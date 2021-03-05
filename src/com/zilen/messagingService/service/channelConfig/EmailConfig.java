package com.zilen.messagingService.service.channelConfig;

import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Email;

import java.util.List;
import java.util.stream.Collectors;

public class EmailConfig implements ChannelConfig {

    @Override
    public void sendConfig(String sender, List<Channel> channels) {
        List<Channel> emails = channels
                .stream()
                .filter(channel -> channel.getClass().equals(Email.class))
                .filter(email -> email.getSender().equals(sender))
                .collect(Collectors.toList());

        if(emails.isEmpty()){
            throw new NullPointerException("email: sender is empty!");
        }
        emails.forEach(email -> System.out.println("email: sent from "+email.getFrom()+" to " +email.getTo()));
    }
}

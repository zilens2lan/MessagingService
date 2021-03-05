package com.zilen.messagingService.service.channelConfig;

import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.SMS;

import java.util.List;
import java.util.stream.Collectors;

public class SMSConfig implements ChannelConfig {

    @Override
    public void sendConfig(String sender, List<Channel> channels) {
        List<Channel> smses = channels
                .stream()
                .filter(channel -> channel.getClass().equals(SMS.class))
                .filter(sms -> sms.getSender().equals(sender))
                .collect(Collectors.toList());

        if(smses.isEmpty()){
            throw new NullPointerException("sms: sender is empty!");
        }
        smses.forEach(sms -> System.out.println("sms: sent from "+sms.getFrom()+" to " +sms.getTo()));
    }
}

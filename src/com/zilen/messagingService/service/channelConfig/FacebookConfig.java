package com.zilen.messagingService.service.channelConfig;

import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Facebook;

import java.util.List;
import java.util.stream.Collectors;

public class FacebookConfig implements ChannelConfig {

    @Override
    public void sendConfig(String sender, List<Channel> channels) {
        List<Channel> facebooks = channels
                .stream()
                .filter(channel -> channel.getClass().equals(Facebook.class))
                .filter(facebook -> facebook.getSender().equals(sender))
                .collect(Collectors.toList());

        if(facebooks.isEmpty()){
            throw new NullPointerException("facebook: sender is empty!");
        }
        facebooks.forEach(facebook -> System.out.println("facebook: sent from "+facebook.getFrom()+" to " +facebook.getTo()));
    }
}

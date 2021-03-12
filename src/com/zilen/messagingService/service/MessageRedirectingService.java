package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.service.channelSender.ChannelSender;

import javax.crypto.spec.PSource;
import java.io.IOException;
import java.util.List;

public class MessageRedirectingService {

    private final List<ChannelSender> channelSenders;
    private final UserService userService;

    public MessageRedirectingService(List<ChannelSender> channelSenders, UserService userService) {
        this.channelSenders = channelSenders;
        this.userService = userService;
    }

    public void redirect(Message message) {
        System.out.println("redirect");

        List<Channel> channels = userService.getUserChannels(message.getUserName());

        for (Channel channel : channels) {
            for (ChannelSender channelSender : channelSenders) {
                if (channelSender.supports(channel)) {
                    channelSender.send(message, channel);
                }
            }
            channelSenders.stream().noneMatch(channelSender -> channelSender.supports(channel));
            //exception
        }
    }
}

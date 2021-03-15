package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.service.channelSender.ChannelSender;

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

        channels.forEach(channel -> channelSenders.stream()
                .filter(channelSender -> channelSender.supports(channel))
                .findAny()
                .ifPresentOrElse(channelSender -> channelSender.send(message, channel), () ->
                        new RuntimeException(("No sender for Channel " + channel.getClass().getSimpleName())))
        );
    }
}


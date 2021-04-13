package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.repository.ChannelRepository;
import com.zilen.messagingservice.service.channelSender.ChannelSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageRedirectingService {

    private final List<ChannelSender> channelSenders;
    private final UserService userService;

    public void redirect(Message message) {
        List<Channel> channels = userService.getUserChannels(message.getUserName());

        channels.forEach(channel -> channelSenders.stream()
                .filter(channelSender -> channelSender.supports(channel))
                .findAny()
                .ifPresentOrElse(channelSender -> channelSender.send(message, channel), () ->
                        new RuntimeException(("No sender for Channel " + channel.getClass().getSimpleName())))
        );
    }
}


package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.service.channelSender.ChannelSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageRedirectingService {

    private final List<ChannelSender> channelSenders;
    private final UserService userService;
    private final MessageService messageService;

    public void redirect(Message message) {
        List<Channel> channels = userService.getUserChannels(message.getUserName());
        messageService.saveMessage(message);

        channels.forEach(channel -> channelSenders.stream()
                .filter(channelSender ->
                        channelSender.supports(channel))
                .findAny()
                .ifPresentOrElse(channelSender ->
                        channelSender.send(message, channel), () ->
                        new RuntimeException(("No sender for Channel " + channel.getClass().getSimpleName())))
        );
    }
}


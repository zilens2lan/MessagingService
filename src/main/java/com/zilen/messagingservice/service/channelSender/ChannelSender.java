package com.zilen.messagingservice.service.channelSender;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.channel.Channel;

public interface ChannelSender {

    void send(Message message, Channel channel);

    boolean supports(Channel channel);
}

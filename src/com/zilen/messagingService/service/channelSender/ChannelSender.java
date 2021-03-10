package com.zilen.messagingService.service.channelSender;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;

public interface ChannelSender {

    void send(Message message, Channel channel);
}

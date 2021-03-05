package com.zilen.messagingService.service.channelConfig;

import com.zilen.messagingService.entity.channel.Channel;

import java.util.List;

public interface ChannelConfig {

    void sendConfig(String sender, List<Channel> channels);
}

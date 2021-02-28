package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;

public interface ChannelSender {

    void send(Message message);
}

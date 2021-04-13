package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.entity.channel.SMS;
import com.zilen.messagingservice.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserService {

    private final ChannelRepository channelRepository;

    public List<Channel> getUserChannels(String userName) {
        List<Channel> channels = channelRepository.findByUserName(userName);
        if (channels.isEmpty()) {
            throw new IllegalStateException("Such User has no channels");
        }
        return channels;
    }
}

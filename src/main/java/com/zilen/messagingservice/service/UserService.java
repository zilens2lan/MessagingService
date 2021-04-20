package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ChannelRepository channelRepository;

    public List<Channel> getUserChannels(String userName) {
        List<Channel> channels = channelRepository.findByUserName(userName);
        return channels;
    }
}

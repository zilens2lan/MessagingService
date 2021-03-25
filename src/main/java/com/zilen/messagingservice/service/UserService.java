package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private ChannelRepository channelRepository;

    public UserService(ChannelRepository channelRepository){
        this.channelRepository = channelRepository;
    }

    public List<Channel> getUserChannels(String userName) {
        List<Channel> channels = channelRepository.findByUserName(userName);
        if (channels.isEmpty()) {
            throw new IllegalStateException("Such User has no channels");
        }
        return channels;
    }
}

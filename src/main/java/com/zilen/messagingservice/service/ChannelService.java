package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelService {

    private final ChannelRepository channelRepository;

    public List<Channel> findByUserName(String userName){
        return channelRepository.findByUserName(userName);
    }
}

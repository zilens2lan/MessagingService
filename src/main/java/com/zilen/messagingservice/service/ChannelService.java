package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.exception.ChannelNotFoundException;
import com.zilen.messagingservice.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChannelService {

    private final ChannelRepository channelRepository;

    public List<Channel> findByUserName(String userName) {
        return channelRepository.findByUserName(userName);
    }

    public void addChannel(Channel channel) {
        channelRepository.save(channel);
    }

    public Channel findById(UUID id) {
        return channelRepository.findById(id)
                .orElseThrow(() ->
                        new ChannelNotFoundException(id));
    }

    public void deleteChannel(UUID id) {
        channelRepository.deleteById(id);
    }
}

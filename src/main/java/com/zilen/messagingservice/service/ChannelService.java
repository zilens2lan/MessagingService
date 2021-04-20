package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<Channel> findById(UUID id) {
        return Optional.of(channelRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Channel '" + id + "' not found")));
    }

    public void deleteChannel(UUID id) {
        channelRepository.deleteById(id);
    }

    public Optional<Channel> updateChannel(UUID id, Channel updatedChannel) {
        return Optional.of(channelRepository.findById(id)
                .map(channel -> {
                    channel = updatedChannel;
                    return channelRepository.save(channel);
                })
                .orElseThrow(() ->
                        new RuntimeException("Channel '" + id + "' not found")));
    }
}
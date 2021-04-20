package com.zilen.messagingservice.controller;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Channel> getChannelsByUserName(@RequestParam(name = "userName", required = false) String userName) {
        return channelService.findByUserName(userName);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addChannel(@RequestBody Channel channel) {
        channelService.addChannel(channel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Channel> findById(@PathVariable UUID id) {
        return channelService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteChannel(@PathVariable UUID id) {
        channelService.deleteChannel(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Channel> updateChannel(@PathVariable UUID id, @RequestBody Channel updatedChannel){
        return channelService.updateChannel(id, updatedChannel);
    }
}

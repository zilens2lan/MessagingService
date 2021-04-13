package com.zilen.messagingservice.controller;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @GetMapping("/userChannels")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Channel> getChannelsByUserName(@RequestParam(defaultValue = "Zilen") String userName) {
        return channelService.findByUserName(userName);
    }
}

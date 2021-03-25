package com.zilen.messagingservice.controller;

import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.repository.ChannelRepository;
import com.zilen.messagingservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private MessageService messageService;

    @GetMapping("/channels/{userName}")
    public List<Channel> getByUserName(@PathVariable String userName) {
        return channelRepository.findByUserName(userName);
    }

    @RequestMapping("/send")
    public void send(){
        messageService.send();
    }
}

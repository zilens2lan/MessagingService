package com.zilen.messagingservice.controller;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.attachment.Audio;
import com.zilen.messagingservice.entity.attachment.Document;
import com.zilen.messagingservice.entity.attachment.Picture;
import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.repository.ChannelRepository;
import com.zilen.messagingservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    private final ChannelRepository channelRepository;
    private final MessageService messageService;

    @Autowired
    ChannelController(ChannelRepository channelRepository, MessageService messageService) {
        this.channelRepository = channelRepository;
        this.messageService = messageService;
    }

    @GetMapping("/{userName}")
    public List<Channel> getChannelsByUserName(@PathVariable String userName) {
        return channelRepository.findByUserName(userName);
    }

    @PostMapping("/send")
    public ResponseEntity<String> send() {
        messageService.send(createMessage());
        return ResponseEntity.status(HttpStatus.OK).body("Message sent");
    }

    private Message createMessage() {
        Document document = Document.builder()
                .id(UUID.randomUUID())
                .title("document")
                .format("doc")
                .size(Byte.MAX_VALUE)
                .build();
        Picture picture = Picture.builder()
                .id(UUID.randomUUID())
                .title("picture")
                .format("png")
                .height(1080)
                .width(1920)
                .build();
        Audio audio = Audio.builder()
                .id(UUID.randomUUID())
                .title("audio")
                .format("mp3")
                .duration(Duration.ofSeconds(364))
                .build();

        Message message = Message.builder()
                .id(UUID.randomUUID())
                .userName("Zilen")
                .text("Text Text Text")
                .dateTime(LocalDateTime.now())
                .attachments(List.of(document, picture, audio))
                .build();

        return message;
    }
}

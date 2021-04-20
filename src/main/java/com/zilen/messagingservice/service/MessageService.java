package com.zilen.messagingservice.service;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.attachment.Audio;
import com.zilen.messagingservice.entity.attachment.Document;
import com.zilen.messagingservice.entity.attachment.Picture;
import com.zilen.messagingservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public void deleteMessage(UUID id){
        messageRepository.deleteById(id);
    }

    public List<Message> findByUserName(String userName){
        return messageRepository.findByUserName(userName);
    }
}

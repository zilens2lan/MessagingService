package com.zilen.messagingservice.repository;

import com.zilen.messagingservice.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends MongoRepository<Message, UUID> {

    List<Message> findByUserName(String userName);
}

package com.zilen.messagingservice.repository;

import com.zilen.messagingservice.entity.channel.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChannelRepository extends MongoRepository<Channel, UUID> {

    List<Channel> findByUserName(String userName);
}

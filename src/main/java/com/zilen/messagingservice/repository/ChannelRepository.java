package com.zilen.messagingservice.repository;

import com.zilen.messagingservice.entity.channel.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "channels", path = "channels")
public interface ChannelRepository extends MongoRepository<Channel, UUID> {

    List<Channel> findByUserName(String userName);
}

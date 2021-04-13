package com.zilen.messagingservice.entity.channel;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@Builder(toBuilder = true)
public class SMS implements Channel {

    private UUID id;
    private String userName;
    private String fromPhoneNumber;
    private String toPhoneNumber;
}

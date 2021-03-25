package com.zilen.messagingservice.entity.channel;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class SMS implements Channel {

    @Id
    private UUID id;
    private String userName;
    private String fromPhoneNumber;
    private String toPhoneNumber;
}

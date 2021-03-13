package com.zilen.messagingService.entity.channel;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Email implements Channel {

    @NonNull
    private UUID id;
    private String userName;
    private String fromEmailAddress;
    private String toEmailAddress;
}

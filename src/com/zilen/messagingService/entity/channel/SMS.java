package com.zilen.messagingService.entity.channel;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class SMS implements Channel {

    @NonNull
    private UUID id;
    private String userName;
    private String fromPhoneNumber;
    private String toPhoneNumber;
}

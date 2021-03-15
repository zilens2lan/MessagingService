package com.zilen.messagingservice.entity.channel;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Facebook implements Channel {

    @NonNull
    private UUID id;
    private String userName;
    private String fromFacebookId;
    private String toFacebookId;
}

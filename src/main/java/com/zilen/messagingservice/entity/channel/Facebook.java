package com.zilen.messagingservice.entity.channel;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Facebook implements Channel {

    @Id
    private UUID id;
    private String userName;
    private String fromFacebookId;
    private String toFacebookId;
}

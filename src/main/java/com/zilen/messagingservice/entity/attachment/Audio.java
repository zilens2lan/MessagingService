package com.zilen.messagingservice.entity.attachment;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Duration;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Audio implements Attachment {

    @Id
    private UUID id;
    private String title;
    private String format;
    private Duration duration;

}

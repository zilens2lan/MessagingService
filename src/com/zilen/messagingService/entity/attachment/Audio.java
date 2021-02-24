package com.zilen.messagingService.entity.attachment;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Audio implements Attachment<Audio> {

    @NonNull
    private UUID id;
    @NonNull
    private String title;
    private String format;

}

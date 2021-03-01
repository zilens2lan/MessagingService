package com.zilen.messagingService.entity.attachment;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Document implements Attachment {

    @NonNull
    private UUID id;
    @NonNull
    private String title;
    private String format;
    private int size;
}

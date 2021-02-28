package com.zilen.messagingService.entity;

import com.zilen.messagingService.entity.attachment.Attachment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Message {

    @NonNull
    private UUID id;
    @NonNull
    private String sender;
    @NonNull
    private String text;
    @NonNull
    private Date date;
    private List<Attachment> attachments;

}

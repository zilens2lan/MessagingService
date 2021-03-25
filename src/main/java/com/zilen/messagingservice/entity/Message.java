package com.zilen.messagingservice.entity;

import com.zilen.messagingservice.entity.attachment.Attachment;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Message {

    @Id
    private UUID id;
    private String userName;
    private String text;
    private LocalDateTime dateTime;
    private List<Attachment> attachments;

}

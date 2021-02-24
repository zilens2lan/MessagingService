package com.zilen.messagingService.entity.attachment;

import java.util.UUID;

public interface Attachment<T> {

    UUID getId();
    void setId(UUID id);
    String getTitle();
    void setTitle(String title);
    String getFormat();
    void setFormat(String format);
}

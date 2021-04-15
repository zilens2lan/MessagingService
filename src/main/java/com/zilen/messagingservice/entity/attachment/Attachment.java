package com.zilen.messagingservice.entity.attachment;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Audio.class, name = "audio"),
        @JsonSubTypes.Type(value = Document.class, name = "document"),
        @JsonSubTypes.Type(value = Picture.class, name = "picture")
})
public interface Attachment {
}

package com.zilen.messagingservice.entity.channel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Email.class, name = "email"),
        @JsonSubTypes.Type(value = Facebook.class, name = "facebook"),
        @JsonSubTypes.Type(value = SMS.class, name = "sms")
})
@Document
@Data
public abstract class Channel {

    private final UUID id;
    private final String userName;
}

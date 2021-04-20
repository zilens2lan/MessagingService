package com.zilen.messagingservice.entity.channel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Email extends Channel {

    private String fromEmailAddress;
    private String toEmailAddress;

    public Email(UUID id, String userName, String fromEmailAddress, String toEmailAddress) {
        super(id, userName);
        this.fromEmailAddress = fromEmailAddress;
        this.toEmailAddress = toEmailAddress;
    }
}
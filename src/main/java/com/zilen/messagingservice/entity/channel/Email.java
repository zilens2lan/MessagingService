package com.zilen.messagingservice.entity.channel;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public class Email extends Channel {

    private String fromEmailAddress;
    private String toEmailAddress;

    public Email(UUID id, String userName, String fromEmailAddress, String toEmailAddress) {
        super(id, userName);
        this.fromEmailAddress = fromEmailAddress;
        this.toEmailAddress = toEmailAddress;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getToEmailAddress() {
        return toEmailAddress;
    }

    public void setToEmailAddress(String toEmailAddress) {
        this.toEmailAddress = toEmailAddress;
    }
}

package com.zilen.messagingservice.entity.channel;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public class SMS extends Channel {

    private String fromPhoneNumber;
    private String toPhoneNumber;

    public SMS(UUID id, String userName, String fromPhoneNumber, String toPhoneNumber) {
        super(id, userName);
        this.fromPhoneNumber = fromPhoneNumber;
        this.toPhoneNumber = toPhoneNumber;
    }

    public String getFromPhoneNumber() {
        return fromPhoneNumber;
    }

    public void setFromPhoneNumber(String fromPhoneNumber) {
        this.fromPhoneNumber = fromPhoneNumber;
    }

    public String getToPhoneNumber() {
        return toPhoneNumber;
    }

    public void setToPhoneNumber(String toPhoneNumber) {
        this.toPhoneNumber = toPhoneNumber;
    }
}

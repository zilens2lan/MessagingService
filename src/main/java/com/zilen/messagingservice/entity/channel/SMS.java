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
public class SMS extends Channel {

    private String fromPhoneNumber;
    private String toPhoneNumber;

    public SMS(UUID id, String userName, String fromPhoneNumber, String toPhoneNumber) {
        super(id, userName);
        this.fromPhoneNumber = fromPhoneNumber;
        this.toPhoneNumber = toPhoneNumber;
    }
}

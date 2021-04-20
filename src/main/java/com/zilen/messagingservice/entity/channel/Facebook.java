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
public class Facebook extends Channel {

    private String fromFacebookId;
    private String toFacebookId;

    public Facebook(UUID id, String userName, String fromFacebookId, String toFacebookId) {
        super(id, userName);
        this.fromFacebookId = fromFacebookId;
        this.toFacebookId = toFacebookId;
    }
}

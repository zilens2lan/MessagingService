package com.zilen.messagingservice.entity.channel;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public class Facebook extends Channel {

    private String fromFacebookId;
    private String toFacebookId;

    public Facebook(UUID id, String userName, String fromFacebookId, String toFacebookId) {
        super(id, userName);
        this.fromFacebookId = fromFacebookId;
        this.toFacebookId = toFacebookId;
    }

    public String getFromFacebookId() {
        return fromFacebookId;
    }

    public void setFromFacebookId(String fromFacebookId) {
        this.fromFacebookId = fromFacebookId;
    }

    public String getToFacebookId() {
        return toFacebookId;
    }

    public void setToFacebookId(String toFacebookId) {
        this.toFacebookId = toFacebookId;
    }


}

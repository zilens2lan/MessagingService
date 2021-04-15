package com.zilen.messagingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChannelNotFoundException extends RuntimeException{

    public ChannelNotFoundException(UUID id){
        super("Could not find Channel '" + id +"'!!!");
    }
}

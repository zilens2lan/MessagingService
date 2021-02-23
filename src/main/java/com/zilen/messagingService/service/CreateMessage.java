package main.java.com.zilen.messagingService.service;

import main.java.com.zilen.messagingService.entity.Message;

public interface CreateMessage {

    Message createMessage();
    String getText();
    String getDate();
}

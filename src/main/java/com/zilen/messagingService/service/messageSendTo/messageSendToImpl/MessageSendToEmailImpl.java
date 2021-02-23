package main.java.com.zilen.messagingService.service.messageSendTo.messageSendToImpl;

import main.java.com.zilen.messagingService.entity.Message;
import main.java.com.zilen.messagingService.service.messageSendTo.MessageSendToEmail;

public class MessageSendToEmailImpl implements MessageSendToEmail {

    @Override
    public void messageSendToEmail(Message message) {
        System.out.println(message.toString()+ "send to Email Success!!!");
    }
}

package main.java.com.zilen.messagingService.service.messageSendTo.messageSendToImpl;

import main.java.com.zilen.messagingService.entity.Message;
import main.java.com.zilen.messagingService.service.messageSendTo.MessageSendTo;

public class MessageSendToEmailImpl implements MessageSendTo {

    @Override
    public void messageSendTo(Message message) {
        System.out.println(message.toString()+ "send to Email Success!!!");
    }
}

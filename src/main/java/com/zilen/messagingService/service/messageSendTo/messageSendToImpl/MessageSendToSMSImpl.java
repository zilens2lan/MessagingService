package main.java.com.zilen.messagingService.service.messageSendTo.messageSendToImpl;

import main.java.com.zilen.messagingService.entity.Message;
import main.java.com.zilen.messagingService.service.messageSendTo.MessageSendTo;

public class MessageSendToSMSImpl implements MessageSendTo {

    @Override
    public void messageSendTo(Message message) {
        if(message.getFiles().isEmpty()){
            System.out.println(message.toString() +"send to SMS Success;");
        }else{
            System.out.println(message.toString()+"Unable to send, please delete the attached files.");
        }
    }
}

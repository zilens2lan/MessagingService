package main.java.com.zilen.messagingService.service.serviceImpl;

import main.java.com.zilen.messagingService.entity.Message;
import main.java.com.zilen.messagingService.service.*;
import main.java.com.zilen.messagingService.service.messageSendTo.MessageSendTo;
import main.java.com.zilen.messagingService.service.messageSendTo.messageSendToImpl.MessageSendToEmailImpl;
import main.java.com.zilen.messagingService.service.messageSendTo.messageSendToImpl.MessageSendToFacebookImpl;
import main.java.com.zilen.messagingService.service.messageSendTo.messageSendToImpl.MessageSendToSMSImpl;

import java.util.ArrayList;
import java.util.List;

public class MessagingServiceImpl implements MessagingService {

    @Override
    public void viewMessage() {
        CreateMessage createMessage = new CreateMessageImpl();
        List<Message> viewList = new ArrayList<>();

        /*
         * Adding a message with an attached file and sending to ...
         * */
        viewList.add(createMessage.createMessage());
        viewList.add(createMessage.createMessage());
        viewList.add(createMessage.createMessage());
        
        FileAttachment fileAttachment = new FileAttachmentImpl();
        fileAttachment.fileAttachment(viewList.get(2));

        MessageSendTo messageSendToSMS = new MessageSendToSMSImpl();
        MessageSendTo messageSendToFacebook = new MessageSendToFacebookImpl();
        MessageSendTo messageSendToEmail = new MessageSendToEmailImpl();

        messageSendToEmail.messageSendTo(viewList.get(2));
        messageSendToSMS.messageSendTo(viewList.get(2));
        messageSendToFacebook.messageSendTo(viewList.get(2));

        if (viewList.isEmpty()) {
            System.out.println("List is Empty");
        } else {
            for (Message message : viewList) {
                System.out.println(message.toString());
            }
        }
    }
}

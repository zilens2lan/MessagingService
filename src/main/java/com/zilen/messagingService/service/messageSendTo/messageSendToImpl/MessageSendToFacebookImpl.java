package main.java.com.zilen.messagingService.service.messageSendTo.messageSendToImpl;

import main.java.com.zilen.messagingService.entity.Message;
import main.java.com.zilen.messagingService.service.messageSendTo.MessageSendTo;

import java.io.File;

public class MessageSendToFacebookImpl implements MessageSendTo {

    @Override
    public void messageSendTo(Message message) {
        for (File file : message.getFiles()) {
            String fileName = file.getName();
            if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
                String ff = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (ff.equals("doc") || ff.equals("png") || ff.equals("jpeg") || ff.equals("jpg") || ff.equals("txt")) {
                }else{
                    System.out.println(message.toString() + " has an invalid file attachment");
                    break;
                }
            }
            System.out.println(message.toString() + " send to Facebook success");
        }
    }
}

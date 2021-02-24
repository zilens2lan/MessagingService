package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.attachment.Attachment;
import com.zilen.messagingService.entity.attachment.Document;
import com.zilen.messagingService.entity.attachment.Picture;

public class FacebookSender implements ChannelSender {

    @Override
    public void sendFiltering(Message message) {
        for (Attachment attachment : message.getAttachmentList()) {
            if (attachment instanceof Document == false
                    && attachment instanceof Picture == false){
                message.getAttachmentList().remove(attachment);
            }
        }
        System.out.println(message.toString()+ "message facebook");
    }
}

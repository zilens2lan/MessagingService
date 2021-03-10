package com.zilen.messagingService.service.channelSender;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Facebook;
import com.zilen.messagingService.entity.channel.SMS;

public class SMSSender implements ChannelSender {

    @Override
    public void send(Message message, Channel channel) {
        Message messageFiltered = Message.builder()
                .id(message.getId())
                .sender(message.getSender())
                .text(message.getText())
                .dateTime(message.getDateTime())
                .attachments(null)
                .build();

        System.out.println("message send to SMS: " + messageFiltered.toString());

        if (!channel.getSender().equals(message.getSender())) {
            throw new IllegalStateException("sms: sender is empty!");
        }

        try {
            SMS sms = ((SMS) channel);
            System.out.println("facebook: sent from " + sms.getFromPhoneNumber() + "to" + sms.getToPhoneNumber());
        }catch (ClassCastException ex){}
    }
}

package com.zilen.messagingService.service.channelSender;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.SMS;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SMSSender implements ChannelSender {

    @Override
    public void send(Message message, Channel channel) {
        assertTrue(channel instanceof SMS, "WRONG TYPE!!!");
        SMS sms = ((SMS) channel);

        Message messageFiltered = Message.builder()
                .id(message.getId())
                .userName(message.getUserName())
                .text(message.getText())
                .dateTime(message.getDateTime())
                .attachments(null)
                .build();

        System.out.println("message send to SMS: " + messageFiltered.toString());
        System.out.println("sms: sent from " + sms.getFromPhoneNumber() + " to " + sms.getToPhoneNumber());
    }
}

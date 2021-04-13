package com.zilen.messagingservice.service.channelSender;

import com.zilen.messagingservice.entity.Message;
import com.zilen.messagingservice.entity.channel.Channel;
import com.zilen.messagingservice.entity.channel.SMS;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
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

    @Override
    public boolean supports(Channel channel) {
        return channel instanceof SMS;
    }
}

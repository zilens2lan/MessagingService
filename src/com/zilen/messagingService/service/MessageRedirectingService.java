package com.zilen.messagingService.service;

import com.zilen.messagingService.entity.Message;
import com.zilen.messagingService.entity.channel.Channel;
import com.zilen.messagingService.entity.channel.Email;
import com.zilen.messagingService.entity.channel.Facebook;
import com.zilen.messagingService.entity.channel.SMS;
import com.zilen.messagingService.service.channelSender.ChannelSender;
import com.zilen.messagingService.service.channelSender.EmailSender;
import com.zilen.messagingService.service.channelSender.FacebookSender;
import com.zilen.messagingService.service.channelSender.SMSSender;

import java.util.List;

public class MessageRedirectingService {

    private List<ChannelSender> channelSenders;

    public MessageRedirectingService(List<ChannelSender> channelSenders) {
        this.channelSenders = channelSenders;
    }

    public void redirect(Message message) {
        System.out.println("redirect");

        UserService userService = new UserService();
        List<Channel> channels = userService.getUserChannels(message.getUserName());

        for (Channel channel : channels) {
            for (ChannelSender channelSender : channelSenders) {
                if (channel instanceof Facebook && channelSender instanceof FacebookSender)
                    channelSender.send(message, channel);
                if (channel instanceof Email && channelSender instanceof EmailSender)
                    channelSender.send(message, channel);
                if (channel instanceof SMS && channelSender instanceof SMSSender)
                    channelSender.send(message, channel);
            }
        }
    }
}

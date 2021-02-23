package main.java.com.zilen.messagingService.service.serviceImpl;

import main.java.com.zilen.messagingService.entity.Message;
import main.java.com.zilen.messagingService.service.CreateMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class CreateMessageImpl implements CreateMessage {

    @Override
    public Message createMessage() {
        return new Message(UUID.randomUUID(), "Zilen", getText(),getDate(),null);
    }

    @Override
    public String getText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String getDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        return formatForDateNow.format(dateNow);
    }
}

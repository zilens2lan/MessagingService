package main.java.com.zilen.messagingService;


import main.java.com.zilen.messagingService.service.MessagingService;
import main.java.com.zilen.messagingService.service.serviceImpl.MessagingServiceImpl;

public class MessageApplication {

    //helloworld
    public static void main(String[] args) {
        System.out.println("start");
        MessagingService messagingService = new MessagingServiceImpl();
        messagingService.viewMessage();
    }
}

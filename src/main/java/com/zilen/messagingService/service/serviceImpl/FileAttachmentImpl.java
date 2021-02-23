package main.java.com.zilen.messagingService.service.serviceImpl;

import main.java.com.zilen.messagingService.entity.Message;
import main.java.com.zilen.messagingService.service.FileAttachment;

import java.io.File;
import java.util.HashSet;

public class FileAttachmentImpl implements FileAttachment {

    @Override
    public Message fileAttachment(Message message) {
        HashSet files = new HashSet();
        File file1 = new File("document.doc");
        File file2 = new File("image.img");
        files.add(file1);
        files.add(file2);
        message.setFiles(files);
        return message;
    }
}

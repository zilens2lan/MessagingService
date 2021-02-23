package main.java.com.zilen.messagingService.entity;

import java.io.File;
import java.util.HashSet;
import java.util.UUID;

public class Message {

    private UUID id;
    private String name;
    private String text;
    private String date;
    private HashSet<File> files;

    public Message(UUID id, String name, String text, String date, HashSet<File> files) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date = date;
        this.files = files;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashSet<File> getFiles() {
        return files;
    }

    public void setFiles(HashSet<File> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!id.equals(message.id)) return false;
        if (!name.equals(message.name)) return false;
        if (!text.equals(message.text)) return false;
        if (!date.equals(message.date)) return false;
        return files != null ? files.equals(message.files) : message.files == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + (files != null ? files.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", files=" + files +
                '}';
    }
}

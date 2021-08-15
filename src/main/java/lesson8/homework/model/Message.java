package lesson8.homework.model;

import java.time.LocalDateTime;

public class Message {
    private String to;
    private String from;
    private String sendAt;
    private String text;

    public Message(String to, String from, String sendAt, String text) {
        this.to = to;
        this.from = from;
        this.sendAt = sendAt;
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSendAt() {
        return sendAt;
    }

    public void setSendAt(String sendAt) {
        this.sendAt = sendAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

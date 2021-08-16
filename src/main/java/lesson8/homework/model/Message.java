package lesson8.homework.model;

import java.time.LocalDateTime;

public class Message {
    private User to;
    private User from;
    private String sendAt;
    private String text;

    public Message(User to, User from, String sendAt, String text) {
        this.to = to;
        this.from = from;
        this.sendAt = sendAt;
        this.text = text;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
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

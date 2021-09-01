package by.it_academy.homeworkRegister.model;

import java.util.Date;

public class Message {
    private String message;
    private String recipient;
    private String sender;
    private Date date;

    public Message(String message, String recipient, String sender, Date date) {
        this.message = message;
        this.recipient = recipient;
        this.sender = sender;
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

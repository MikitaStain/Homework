package by.it_academy.homeworkRegister.model;

public class Message {
    private String message;
    private String sender;
    private String recipient;
    private String date;

    public Message(String message, String sender, String recipient, String date) {
        this.message = message;
        this.sender = sender;
        this.recipient = recipient;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

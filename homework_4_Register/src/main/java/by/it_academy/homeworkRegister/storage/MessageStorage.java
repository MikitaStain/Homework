package by.it_academy.homeworkRegister.storage;

import by.it_academy.homeworkRegister.model.Message;

import java.util.HashMap;
import java.util.Map;

public class MessageStorage {
    private static final MessageStorage instance = new MessageStorage();
    private final Map<String, Message> messages;

    public MessageStorage() {
        this.messages = new HashMap<>();
    }
    public Map<String,Message> getMessages(){
        return messages;
    }
    public static MessageStorage getInstance(){
        return instance;
    }
}

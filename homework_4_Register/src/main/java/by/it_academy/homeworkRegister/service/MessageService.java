package by.it_academy.homeworkRegister.service;

import by.it_academy.homeworkRegister.model.Message;
import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.service.api.IMessageService;
import by.it_academy.homeworkRegister.storage.MessageStorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class MessageService implements IMessageService {
    private static final MessageService instance = new MessageService();
    private final MessageStorage messageStorage;

    public MessageService() {
        this.messageStorage = MessageStorage.getInstance();
    }

    @Override
    public void addMessage(String login, Message message) {

        this.messageStorage.getMessages().put(login, message);
    }

    @Override
    public boolean chekMessage(String message) {

        return message.equals("");
    }

    @Override
    public List<String> getInfoMessage1(HashMap <String, Message> infoMessage, String login ){

        Message messageInfo = infoMessage.get(login);
        String message = messageInfo.getMessage();
        String sender = messageInfo.getSender();
        String recipient = messageInfo.getRecipient();
        String date = messageInfo.getDate().toString();

        List<String> listMessage = new ArrayList<>();
        listMessage.add(message);
        listMessage.add(sender);
        listMessage.add(recipient);
        listMessage.add(date);

        return listMessage;


    }
    @Override
     public List<String> getInfoMessage(String sender) {//возвращает информацию о сообщении по отправител
         List<String> info = (List<String>) messageStorage.getMessages().get(sender);
         return info;
     }


    public static MessageService getInstance() {
        return instance;
    }
}

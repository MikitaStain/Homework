package by.it_academy.homeworkRegister.service;

import by.it_academy.homeworkRegister.model.Message;
import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.storage.MessageStorage;

import java.util.List;


public class MessageService {
    private static final MessageService instance = new MessageService();
    private final MessageStorage messageStorage;

    public MessageService() {
        this.messageStorage = MessageStorage.getInstance();
    }

    public void addMessage(String textMessage, Message message) {
        if (textMessage.equals("")) {
            throw new IllegalArgumentException("Отсутствует текст сообщения!!");
        }

        this.messageStorage.getMessages().put(textMessage, message);
    }

    public User getSender(String login) {

        return UserService.getInstance().getUser(login);
    }

    public User getRecipient(String login) {

        return UserService.getInstance().getUser(login);
    }

    public boolean validation(String recipient) {//Проверка на получателя

        if (!UserService.getInstance()
                .getUsers()
                .containsKey(recipient)) {
            throw new IllegalArgumentException("Пользователь не найден");
        }
        return true;
    }

  // public List<String> getInfoMessage(String sender) {//возвращает информацию о сообщении по отправителю

  //     List<String> info = (List<String>) messageStorage.getMessages().get(sender);

  //     return info;
  // }


    public static MessageService getInstance() {
        return instance;
    }
}

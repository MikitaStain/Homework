package by.it_academy.homeworkRegister.service;

import by.it_academy.homeworkRegister.model.Message;
import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.service.api.IMessageService;
import by.it_academy.homeworkRegister.storage.MessageStorage;




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

    // public List<String> getInfoMessage(String sender) {//возвращает информацию о сообщении по отправителю

    //     List<String> info = (List<String>) messageStorage.getMessages().get(sender);

    //     return info;
    // }


    public static MessageService getInstance() {
        return instance;
    }
}

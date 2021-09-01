package by.it_academy.homeworkRegister.service.api;

import by.it_academy.homeworkRegister.model.Message;

public interface IMessageService {

    boolean chekMessage(String message);

    void addMessage(String login, Message message);
}

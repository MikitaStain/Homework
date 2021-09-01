package by.it_academy.homeworkRegister.service.api;

import by.it_academy.homeworkRegister.model.Message;

import java.util.HashMap;
import java.util.List;

public interface IMessageService {

    boolean chekMessage(String message);

    void addMessage(String login, Message message);

    List<String> getInfoMessage1(HashMap<String, Message> infoMessage, String login );

    List<String> getInfoMessage(String sender);
}

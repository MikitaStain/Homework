package by.it_academy.homeworkRegister.storage.api;

import by.it_academy.homeworkRegister.model.Message;

import java.util.Map;

public interface IMessageStorage {

    Map<String, Message> getMessages();



}

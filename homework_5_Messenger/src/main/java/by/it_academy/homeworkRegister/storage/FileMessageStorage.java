package by.it_academy.homeworkRegister.storage;

import by.it_academy.homeworkRegister.model.Message;
import by.it_academy.homeworkRegister.storage.api.IMessageStorage;

import java.util.Map;

public class FileMessageStorage implements IMessageStorage {

    private static FileMessageStorage instance = new FileMessageStorage();

    @Override
    public Map<String, Message> getMessages() {
        return null;
    }

    public static FileMessageStorage getInstance(){
        return instance;
    }
}

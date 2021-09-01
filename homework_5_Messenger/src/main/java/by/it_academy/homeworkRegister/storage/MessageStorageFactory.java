package by.it_academy.homeworkRegister.storage;

import by.it_academy.homeworkRegister.storage.api.IMessageStorage;

public class MessageStorageFactory {
    private static TypeStorage type = null;

    public synchronized static void setType(TypeStorage type) {
        if (type != null) {
            MessageStorageFactory.type = type;
        } else {
            throw new IllegalStateException("Не изменный тип хранилища");
        }
    }

    public static IMessageStorage getInstance() {
        if (type == null) {
            throw new IllegalStateException("Не задан тип хранилища");
        }
        switch (type) {
            case FILE:
                return FileMessageStorage.getInstance();
            case MEMORY:
                return MessageStorage.getInstance();
            default:
                throw new IllegalStateException("Не известный тип хранилища");
        }
    }
}


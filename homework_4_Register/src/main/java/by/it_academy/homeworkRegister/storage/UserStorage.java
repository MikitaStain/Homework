package by.it_academy.homeworkRegister.storage;

import by.it_academy.homeworkRegister.model.User;

import java.util.HashMap;
import java.util.Map;


public class UserStorage {
    private static final UserStorage instance = new UserStorage();
    private final Map<String, User> users;

    public UserStorage() {
        this.users = new HashMap<>();
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public static UserStorage getInstance() {
        return instance;
    }
}

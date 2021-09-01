package by.it_academy.homeworkRegister.storage.api;

import by.it_academy.homeworkRegister.model.User;

import java.util.Map;

public interface IUserStorage {

    Map<String, User> getUsers();
}

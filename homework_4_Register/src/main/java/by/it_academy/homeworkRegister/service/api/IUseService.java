package by.it_academy.homeworkRegister.service.api;

import by.it_academy.homeworkRegister.model.User;


import java.util.Map;

public interface IUseService {

    boolean validationData(String login, String name, String password, String birthDay);

    void addUser(String login, User user);

    boolean chekUserLoginAndPassword(String login, String password);

    User getUser(String login);

    Map<String, User> getUsers();

    boolean chekUserLogin(String login);

    String myLogin(User user);



}

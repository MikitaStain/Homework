package by.it_academy.homeworkRegister.service;

import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.storage.UserStorage;

import java.util.Map;

public class UserService {
    private static final UserService instance = new UserService();
    private final UserStorage userStorage;

    public UserService() {
        this.userStorage = UserStorage.getInstance();
    }

    public boolean validationData(String login, String name, String password, String birthDay) {
        return login != ""
                && name != ""
                && password != ""
                && birthDay != "";
    }

    public void addUser(String login, User user) {
        this.userStorage.getUsers().put(login, user);//добавит логин(key) и юзера(value) в мапу
    }


    public User getUser(String login) {

        return this.userStorage.getUsers().get(login); //вернет User по ключу(login)
    }

    public String[] infoUser(User user, String loginUser) {
        String birthDay = this.userStorage.getUsers().get(loginUser).getBirthDay();
        String name = this.userStorage.getUsers().get(loginUser).getName();
        String login = this.userStorage.getUsers().get(loginUser).getLogin();

        return new String[]{name, login, birthDay};
    }

    public boolean chekUserLoginAndPassword(String login, String password) {
        if (getUsers().containsKey(login)) { //вернет true если логин существует
            String checkPassword = getUsers().get(login).getPassword();//проверка на пароль
            return checkPassword.equals(password);
        }else{
        return false;}

    }


    public Map<String, User> getUsers() {
        return this.userStorage.getUsers();
    }

    public static UserService getInstance() {
        return instance;
    }
}

package by.it_academy.homeworkRegister.service;

import by.it_academy.homeworkRegister.model.User;
import by.it_academy.homeworkRegister.service.api.IUseService;
import by.it_academy.homeworkRegister.storage.UserStorage;

import java.util.Map;

public class UserService implements IUseService {
    private static final UserService instance = new UserService();
    private final UserStorage userStorage;

    public UserService() {
        this.userStorage = UserStorage.getInstance();
    }

    @Override
    public boolean validationData(String login, String name, String password, String birthDay) {
        return !login.equals("")
                && !name.equals("")
                && !password.equals("")
                && !birthDay.equals("");
    }

    @Override
    public void addUser(String login, User user) {
        if (userStorage.getUsers().containsKey(login)) { //проверка на наличие данного ключа
            throw new IllegalArgumentException(login + ": данный логин уже занят!!!");
        }
        this.userStorage.getUsers().put(login, user);//добавит логин(key) и юзера(value) в мапу
    }

    @Override
    public User getUser(String login) {

        return this.userStorage.getUsers().get(login); //вернет User по ключу(login)
    }

    @Override
    public Map<String, User> getUsers() {
        return this.userStorage.getUsers();
    }

    public String[] infoUser(User user, String loginUser) {
        String birthDay = this.userStorage.getUsers().get(loginUser).getBirthDay();
        String name = this.userStorage.getUsers().get(loginUser).getName();
        String login = this.userStorage.getUsers().get(loginUser).getLogin();

        return new String[]{name, login, birthDay};
    }

    @Override
    public boolean chekUserLoginAndPassword(String login, String password) {
        if (getUsers().containsKey(login)) { //вернет true если логин существует
            String checkPassword = getUsers().get(login).getPassword();//проверка на пароль
            return checkPassword.equals(password);
        } else {
            return false;
        }

    }

    public static UserService getInstance() {
        return instance;
    }
}

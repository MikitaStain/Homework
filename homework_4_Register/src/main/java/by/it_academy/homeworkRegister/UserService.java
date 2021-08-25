package by.it_academy.homeworkRegister;

import java.util.Map;

public class UserService {
    private static final UserService instance = new UserService();
    private final UserStorage userStorage;

    public UserService() {
        this.userStorage = UserStorage.getInstance();
    }

    public boolean validationData(String login, User user) {
        if (login != null
                && user.getBirthDay() != null
                && user.getLogin() != null
                && user.getName() != null
                && user.getPassword() != null) {
            return true;
        } else {
            return false;
        }
    }

    public void addUser(String login, User user) {
        this.userStorage.getUsers().put(login, user);//добавит логин(key) и юзера(value) в мапу
    }

    public boolean checkLogin(String login) {

        return userStorage.getUsers().containsKey(login);//вернет true если есть данный ключ
    }

    public User getUser(String login) {
        User user = this.userStorage.getUsers().get(login);

        return user; //вернет User по ключу(login)
    }

    public String[] infoUser(User user, String loginUser) {
        String birthDay = this.userStorage.getUsers().get(loginUser).getBirthDay();
        String name = this.userStorage.getUsers().get(loginUser).getName();
        String login = this.userStorage.getUsers().get(loginUser).getLogin();

        return new String[]{name, login, birthDay};
    }

    public boolean chekUserLoginAndPassword(String login, String password) {
        this.userStorage.getUsers();
        User user = getUsers(login).get(login);
        String getPassword = user.getPassword();

        return getPassword.equals(password);//вернет true если логин и пароль введены корректно
    }


    public Map<String, User> getUsers(String login) {
        return this.userStorage.getUsers();
    }

    public static UserService getInstance() {
        return instance;
    }
}

package by.it_academy.homeworkRegister;

public class User {
    private String login;
    private String password;
    private String name;
    private String birthDay;

    public User(String login, String password, String name, String birthDay) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}

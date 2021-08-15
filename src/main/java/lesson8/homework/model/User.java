package lesson8.homework.model;

import java.util.Objects;

public class User{
    private String login;
    private String password;
    private String name;
    private String birthDate;

    public User(String login, String password, String name, String birthDate) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}

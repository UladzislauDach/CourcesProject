package lesson8.homework.view;

import lesson8.homework.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static final Storage instance = new Storage();

    private final List<User> userList = new ArrayList<>();
    private final Map<Long, String> messageMap = new TreeMap<>();

    public static Storage getInstance() {
        return instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(String login, String password){
        User user = userList.stream().filter(o-> o.getLogin().equals(login)
                && o.getPassword().equalsIgnoreCase(password)).findFirst().orElse(null);
        return user;
    }

    public boolean existUser (String login, String password){
       return userList.stream().anyMatch(o -> o.getLogin().equals(login) && o.getPassword().equals(password));
    }

}

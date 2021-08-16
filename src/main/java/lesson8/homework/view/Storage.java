package lesson8.homework.view;

import lesson8.homework.model.Message;
import lesson8.homework.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Storage {
    private static final Storage instance = new Storage();

    private Storage() {
    }

    private final List<User> userList = new ArrayList<>();
    private final List<Message> messageList = new ArrayList<>();

    public static Storage getInstance() {
        return instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    private User getUserByLogin(String login) {
        return userList.stream().filter(o -> o.getLogin().equals(login)).findFirst().orElse(null);
    }

    public User getUser(String login, String password) {
        return userList.stream().filter(o -> o.getLogin().equals(login)
                && o.getPassword().equalsIgnoreCase(password)).findFirst().orElse(null);
    }

    public boolean existUserLogin(String login) {
        return userList.stream().anyMatch(o -> o.getLogin().equals(login));
    }

    public boolean addMessage(String to, String from, String text) {
        if (!existUserLogin(to)) return false;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        messageList.add(new Message(getUserByLogin(to), getUserByLogin(from), now.format(formatter), text));
        return true;
    }

    public List<Message> getMessageList(String ownerLogin) {
        return messageList.stream().filter(m -> m.getTo().getLogin().equals(ownerLogin)).collect(Collectors.toList());
    }

}

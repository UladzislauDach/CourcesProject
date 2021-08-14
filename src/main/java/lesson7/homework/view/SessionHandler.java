package lesson7.homework.view;

import lesson7.homework.model.PersonDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionHandler implements IStorageHandler {

    private static final SessionHandler instance = new SessionHandler();

    public static SessionHandler getInstance() {
        return instance;
    }

    public void savePerson(HttpServletResponse response, HttpServletRequest request, PersonDto personDto) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60 * 24);
        session.setAttribute("person", personDto);
    }

    public PersonDto getPerson(HttpServletRequest request) {
        HttpSession session = request.getSession();
        PersonDto resultPerson = (PersonDto) session.getAttribute("person");
        if (resultPerson == null) {
            throw new IllegalArgumentException("Нет данных из session");
        }
        return resultPerson;
    }
}

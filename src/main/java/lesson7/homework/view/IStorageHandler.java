package lesson7.homework.view;

import lesson7.homework.model.PersonDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IStorageHandler {
    void savePerson(HttpServletResponse response, HttpServletRequest request, PersonDto personDto);

    PersonDto getPerson(HttpServletRequest request);
}

package lesson6.homework;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Repository {
    private static final String FIRST_NAME_PARAM = "firstName";
    private static final String LAST_NAME_PARAM = "lastName";
    private static final String AGE_PARAM = "age";

    public static void saveUserToCookies(HttpServletResponse response, HttpServletRequest request) {
        PersonDto personDto = PersonService.getPersonDtoFromRequest(request);
        Cookie cookie1 = new Cookie(FIRST_NAME_PARAM, personDto.getFirstName());
        Cookie cookie2 = new Cookie(LAST_NAME_PARAM, personDto.getLastName());
        Cookie cookie3 = new Cookie(AGE_PARAM, String.valueOf(personDto.getAge()));
        cookie1.setMaxAge(60 * 60 * 12);
        cookie2.setMaxAge(60 * 60 * 12);
        cookie3.setMaxAge(60 * 60 * 12);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
    }

    public static void saveUserToSession(HttpServletRequest request) {
        PersonDto personDto = PersonService.getPersonDtoFromRequest(request);
        HttpSession session = request.getSession();
        session.setAttribute("person", personDto);
    }

    public static PersonDto getUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        PersonDto resultPerson = (PersonDto) session.getAttribute("person");
//        if (resultPerson == null){
//            throw new IllegalArgumentException("Нет даных в Session");
//        }
        return resultPerson;
    }

    public static PersonDto getUserFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        PersonDto resultPerson = new PersonDto();
        for (Cookie cookie : cookies) {
            switch (cookie.getName()) {
                case FIRST_NAME_PARAM:
                    resultPerson.setFirstName(cookie.getValue());
                    break;
                case LAST_NAME_PARAM:
                    resultPerson.setLastName(cookie.getValue());
                    break;
                case AGE_PARAM:
                    resultPerson.setAge(Integer.parseInt(cookie.getValue()));
                    break;
            }
        }
        if (resultPerson.getFirstName()== null || resultPerson.getLastName() == null || resultPerson.getAge() == 0){
            return null;
        }
        return resultPerson;
    }

}

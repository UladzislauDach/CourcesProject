package lesson7.homework.view;

import lesson7.homework.model.PersonDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesHandler implements IStorageHandler {
    private static final String FIRST_NAME_PARAM = "firstName";
    private static final String LAST_NAME_PARAM = "lastName";
    private static final String AGE_PARAM = "age";

    private static final CookiesHandler instance = new CookiesHandler();

    public static CookiesHandler getInstance() {
        return new CookiesHandler();
    }

    public void savePerson(HttpServletResponse response, HttpServletRequest request, PersonDto personDto) {
        addCookiesToResponse(response, FIRST_NAME_PARAM, personDto.getFirstName());
        addCookiesToResponse(response, LAST_NAME_PARAM, personDto.getLastName());
        addCookiesToResponse(response, AGE_PARAM, String.valueOf(personDto.getAge()));
    }

    private void addCookiesToResponse(HttpServletResponse response, String cookiesName, String cookiesValue) {
        Cookie cookie = new Cookie(cookiesName, cookiesValue);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }

    public PersonDto getPerson(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            throw new IllegalArgumentException("Нет данных из cookies");
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
        if (resultPerson.getFirstName() == null || resultPerson.getLastName() == null || resultPerson.getAge() == 0) {
            throw new IllegalArgumentException("Нет обязательных параметров из cookies");
        }
        return resultPerson;
    }

}

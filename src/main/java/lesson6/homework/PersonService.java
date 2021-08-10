package lesson6.homework;

import javax.servlet.http.HttpServletRequest;

public class PersonService {

    public static PersonDto getPersonDtoFromRequest(HttpServletRequest request) {
        String[] personField = getParamFromUrl(request, new String[]{"firstName", "lastName", "age"});
        PersonDto personDto = new PersonDto(personField[0], personField[1],
                Integer.parseInt(personField[2]));
        return personDto;
    }

    private static String[] getParamFromUrl(HttpServletRequest request, String[] paramNames) {
        String[] resultValue = new String[paramNames.length];
        for (int i = 0; i < resultValue.length; i++) {
            String value = request.getParameter(paramNames[i]);
            if (value == null) {
                throw new IllegalArgumentException("Нет одного из обязательных параметров");
            }
            resultValue[i] = value;
        }
        return resultValue;
    }
}

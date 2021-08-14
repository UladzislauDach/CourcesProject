package lesson7.homework.model;

import javax.servlet.http.HttpServletRequest;

public class PersonDto {
    private String firstName;
    private String lastName;
    private int age;

    public PersonDto() {
    }

    public PersonDto(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void initPersonDtoFromRequest(HttpServletRequest request) {
        String[] personField = getParamFromUrlAsArray(request, new String[]{"firstName", "lastName", "age"});
        this.firstName = personField[0];
        this.lastName = personField[1];
        this.age = Integer.parseInt(personField[2]);
    }

    private static String[] getParamFromUrlAsArray(HttpServletRequest request, String[] paramNames) {
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

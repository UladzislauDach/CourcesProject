package lesson1.homework.classesForMethodsExample;

/**
 * This enum consist info about car body type
 * @author uladz
 * @version 1.1
 */

public enum BodyType {
    SEDAN,
    UNIVERSAL,
    TRUCK;


    /**
     * Method for parsing string to BodyType
     * @param str some string for parsing
     * @throws IllegalArgumentException if you transfer illegal argument
     * @return test
     */
    public static BodyType parseFromString(String str) {
        if (str == null) throw new IllegalArgumentException("Empty string in enum parser");
        return BodyType.valueOf(str.toUpperCase());
    }
}

package lesson1.task1;

public class CheckString {

    private CheckString() {
    }

    public static long countNum(String s) {
        long result = 0;
        char[] strAsChar = s.toCharArray();
        for (char c : strAsChar) {
            if (Character.isDigit(c)) result++;
        }
        return result;
    }
}

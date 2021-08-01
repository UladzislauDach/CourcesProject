package lesson1.homework;

import lesson1.homework.classesForMethodsExample.BodyType;
import lesson1.homework.classesForMethodsExample.MaintenanceDto;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is my class how contains my old methods for testing in this homework.
 *
 * @author uladz
 * @version 1.1
 */
public class MethodsExample {

    private MethodsExample() {
    }

    /**
     * This method parsing .xml or .xlsx file to map. In this map used key {@link BodyType} and he contains
     * list of {@link MaintenanceDto}
     *
     * @param file is input file
     * @return result as map with key {@link BodyType} and value List of {@link MaintenanceDto}
     * @see BodyType
     * @see MaintenanceDto
     */
    public static Map<BodyType, List<MaintenanceDto>> getMaintenanceMap(File file) {
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException | InvalidFormatException e) {
            return null;
        }
        int sheetQuantity = workbook.getNumberOfSheets();
        Map<BodyType, List<MaintenanceDto>> result = new TreeMap<>();
        for (int i = 0; i < sheetQuantity; i++) {
            String sheetName = workbook.getSheetName(i);
            BodyType bodyType = BodyType.parseFromString(sheetName);
            MaintenanceDto maintenanceDto;
            List<MaintenanceDto> list = new ArrayList<>();
            Iterator<Row> iterator = workbook.getSheet(sheetName).rowIterator();
            iterator.next();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                maintenanceDto = new MaintenanceDto.Builder()
                        .setOperationName(row.getCell(0).getStringCellValue())
                        .setOperationCode((int) row.getCell(1).getNumericCellValue())
                        .setDescription(row.getCell(2).getStringCellValue())
                        .setParts(row.getCell(3).getStringCellValue())
                        .setInterval((int) row.getCell(4).getNumericCellValue())
                        .build();
                list.add(maintenanceDto);
            }
            result.put(bodyType, list);
        }
        return result;
    }

    /**
     * This method for checking string for palindromic number
     *
     * @param s it's some string
     * @return true - if string is palindromic number, else - false
     */
    public static boolean isPalindromicNum(String s) {
        try {
            Long.parseLong(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    /**
     * This method checking string to palindromic with ignore space and case
     *
     * @param s some string
     * @return true if string is palindromic
     */
    public static boolean isPalindromicStringIgnoreSpaceAndCase(String s) {
        s = s.toLowerCase().replaceAll(" ", "");
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    /**
     * This method return number of Fibonacci on n-position
     *
     * @param n - some integer number. Position of Fibonacci numbers
     * @return Fibonacci numbers as long
     */
    public static long fibonacciNum(int n) {
        if (n <= 2) return n - 1;
        if (n == 3) return 1;
        long[] arr = new long[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i - 1] = arr[i - 3] + arr[i - 2];
        }
        return arr[n - 1];
    }

    /**
     * This method return prefix of string array
     *
     * @param strings - some integer number. Position of Fibonacci numbers
     * @return prefix as String
     */
    public static String getPrefix(String[] strings) {
        int minStrLength = Integer.MAX_VALUE;
        for (String s : strings) if (s.length() < minStrLength) minStrLength = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minStrLength; i++) {
            char currentChar = strings[0].charAt(i);
            int iterCount = 1;
            for (int j = 1; j < strings.length; j++) {
                if (strings[j].charAt(i) == currentChar) {
                    iterCount++;
                    if (iterCount == strings.length) {
                        stringBuilder.append(currentChar);
                    }
                } else break;
            }
        }
        return stringBuilder.toString();
    }
}

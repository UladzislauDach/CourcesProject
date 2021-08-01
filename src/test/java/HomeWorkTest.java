import lesson1.homework.MethodsExample;
import lesson1.homework.classesForMethodsExample.BodyType;
import lesson1.homework.classesForMethodsExample.MaintenanceDto;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class HomeWorkTest {

    private static MaintenanceDto maintenanceDto;

    @BeforeAll
    public static void initMaintenanceDto() {
        maintenanceDto = new MaintenanceDto("test", 1, "test1",
                "test2", 10);
    }

    @Test
    public void shouldCheckThisStringPalindromicNumOrNo() {
        Assertions.assertTrue(MethodsExample.isPalindromicNum("12321"));
        Assertions.assertFalse(MethodsExample.isPalindromicNum("122321"));
        Assertions.assertFalse(MethodsExample.isPalindromicNum("test"));
    }

    @Test
    public void shouldCheckThisStringPalindromicStringOrNo() {
        Assertions.assertTrue(MethodsExample.isPalindromicStringIgnoreSpaceAndCase("А роза упала на лапу Азора"));
        Assertions.assertFalse(MethodsExample.isPalindromicStringIgnoreSpaceAndCase("тест"));
    }

    @ParameterizedTest
    @MethodSource("argumentForFibonacci")
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    public void test(long expected, int paramForCheckMethod) {
        Assertions.assertEquals(expected, MethodsExample.fibonacciNum(paramForCheckMethod));
        Assertions.assertEquals(expected, MethodsExample.fibonacciNum(paramForCheckMethod));
    }

    public static Stream<Arguments> argumentForFibonacci() {
        return Stream.of(
                arguments(4181, 20),
                arguments(6765, 21),
                arguments(1, 2),
                arguments(1, 3),
                arguments(2, 4)
        );
    }

    @Test
    public void shouldThrowExceptionByExcelParserException() {
        Assertions.assertThrows(NotOfficeXmlFileException.class, () ->
                MethodsExample.getMaintenanceMap(new File("pom.xml")));
        Assertions.assertThrows(InvalidOperationException.class, () ->
                MethodsExample.getMaintenanceMap(new File("someName.test")));

    }



    @ParameterizedTest
    @MethodSource("argumentsForCheckExcelParser")
    public void checkExcelParser(BodyType bodyType, int elementIndex, String expected) throws IOException, InvalidFormatException {
        File file = new File("MaintenancePattern.xlsx");
        Map<BodyType, List<MaintenanceDto>> mapForTest = MethodsExample.getMaintenanceMap(file);
        String actual = mapForTest.get(bodyType).get(elementIndex).getOperationName();
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> argumentsForCheckExcelParser() {
        return Stream.of(
                arguments(BodyType.SEDAN, 0, "Change engine oil"),
                arguments(BodyType.UNIVERSAL, 1, "Change engine oilfilter"),
                arguments(BodyType.TRUCK, 2, "Change engine airfilter")
        );
    }

    @Test
    public void checkMaintenanceDto() {
        Assertions.assertEquals("test", maintenanceDto.getOperationName());
        Assertions.assertEquals(1, maintenanceDto.getOperationCode());
        Assertions.assertEquals("test1", maintenanceDto.getDescription());
        Assertions.assertEquals("test2", maintenanceDto.getParts());
        Assertions.assertEquals(10, maintenanceDto.getInterval());
    }

    @Test
    public void checkGetPrefix(){
       Assertions.assertEquals("test", MethodsExample.getPrefix(new String [] {"test32", "test12", "testewr"}));
    }


}
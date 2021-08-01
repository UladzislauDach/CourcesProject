import lesson1.task1.CheckString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CheckStringTest {

    @ParameterizedTest
    @MethodSource ("validString")
    public void validCheck(long excepted, String test) {
        Assertions.assertEquals(excepted, CheckString.countNum(test));
    }

    public static Stream<Arguments> validString() {
        return Stream.of(
                arguments(1, "ttest1"),
                arguments(4, "ttest1233"),
                arguments(0, "ttesto")
        );
    }


}

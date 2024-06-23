import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase {


    @Test
    void testFactorialOfZero() {
        BigInteger actual = Factorial.getFactorial(0);
        assertEquals(BigInteger.ONE, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    void testFactorialOfPositiveNumber(int number, BigInteger expected) {
        BigInteger actual = Factorial.getFactorial(number);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void testFactorialOfNegativeNumbers(int input) {
        try {
            Factorial.getFactorial(input);
            Assertions.fail("Ожидалось, что будет сгенерировано исключение IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            assertEquals("Факториал — функция, определённая на множестве неотрицательных целых чисел.", e.getMessage());
        }
    }

    @Test
    void testFactorialOfLargeNumber() {
        BigInteger expected = new BigInteger("51090942171709440000");
        BigInteger actual = Factorial.getFactorial(21);
        assertEquals(expected, actual);
    }
}
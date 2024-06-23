import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;


public class TestCase {

    @Test
    void testFactorialOfZero() {
        BigInteger actual = Factorial.getFactorial(0);
        assertEquals(BigInteger.ONE, actual);
    }

    @Test(dataProvider = "positiveNumbers")
    public void testFactorialOfPositiveNumber(int number, BigInteger expected) {
        BigInteger actual = Factorial.getFactorial(number);
        assertEquals(expected, actual);
    }

    @DataProvider(name = "positiveNumbers")
    public Object[][] positiveNumbers() {
        return new Object[][]{
                {1, BigInteger.ONE},
                {2, new BigInteger("2")},
                {3, new BigInteger("6")},
                {4, new BigInteger("24")},
                {5, new BigInteger("120")}
        };
    }

    @Test(dataProvider = "negativeNumbers")
    public void testFactorialOfNegativeNumbers(int input, String expectedErrorMessage) {
        try {
            Factorial.getFactorial(input);
            Assert.fail("Ожидалось, что будет сгенерировано исключение IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            assertEquals(expectedErrorMessage, e.getMessage());
        }
    }

    @DataProvider(name = "negativeNumbers")
    public Object[][] negativeNumbers() {
        return new Object[][]{
                {-1, "Факториал — функция, определённая на множестве неотрицательных целых чисел."},
                {-5, "Факториал — функция, определённая на множестве неотрицательных целых чисел."},
                {-10, "Факториал — функция, определённая на множестве неотрицательных целых чисел."}
        };
    }

    @Test
    void testFactorialOfLargeNumber() {
        BigInteger expected = new BigInteger("51090942171709440000");
        BigInteger actual = Factorial.getFactorial(21);
        assertEquals(expected, actual);
    }
}
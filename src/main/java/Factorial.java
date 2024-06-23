 import java.math.BigInteger;

    public class Factorial {
        public static void main(String[] args) {
            System.out.println(getFactorial(21));
        }
        public static BigInteger getFactorial(int f) {
            if (f < 0)
                throw new IllegalArgumentException("Факториал — функция, определённая на множестве неотрицательных целых чисел.");

            if (f == 0)
                return BigInteger.ONE;
            BigInteger factorial = BigInteger.ONE;
            for (int i = 1; i <= f; i++) {
                factorial = factorial.multiply( BigInteger.valueOf(i));
            }
            return factorial;
        }
    }



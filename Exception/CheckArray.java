package Exception;

public class CheckArray {
    public static void arrayCheck(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("Неправильный размер массива. Ожидаемый размер 4х4.");
        }
        for (String[] column : array) {
            if (column.length != 4) {
                throw new MyArraySizeException("Неправильный размер массива. Ожидаемый размер 4х4.");
            }
        }
    }
}


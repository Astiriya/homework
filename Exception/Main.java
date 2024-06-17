package Exception;

public class Main {

    public static void main(String[] args) {
        String[][] array = {
                {"1", "два", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            CheckArray.arrayCheck(array);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            return;
        }

        int sum = 0;

        try {
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    try {
                        sum += Integer.parseInt(array[row][column]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Некорректные данные в ячейке [" + row + "][" + column + "]: " + array[row][column]);
                    }
                }
            }
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());

        }
    }
}

package lesson_2;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        summArray(array);

        String[][] array1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}
        };

        summArray(array1);

        String[][] array2 = {
                {"1", "два", "3", "4"},
                {"5", "6", "7", "восемь"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        summArray(array2);

    }

    static void summArray (String[][] array) {

        int summ = 0;

        try{
            if (array.length != 4) {
                throw new MyArraySizeException();
            } else {
                for (int i =0; i < array.length; i++) {
                    if (array[i].length != 4){
                        throw new MyArraySizeException();
                    }
                }
            }
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    if (Character.isDigit(Integer.parseInt(array[i][j]))){
                        throw new MyArrayDataException();
                    } else {
                        summ += Integer.parseInt(array[i][j]);
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Ошибка данных в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        System.out.println("Сумма равна: " + summ);
        System.out.println();
    }
}
package lesson_2;

public class MyArraySizeException extends Exception {
    @Override
    public String getMessage() {
        return "Размер массива не равен 4x4";
    }
}
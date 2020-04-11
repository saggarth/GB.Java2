package lesson_3;

public class Task2 {
    public static void main(String[] args) {
        PhoneBook testBook = new PhoneBook();
        testBook.add("Иванов", "111-111");
        testBook.add("Иванов", "222-222");
        testBook.add("Иванов", "333-333");
        testBook.add("Петров", "444-444");
        testBook.add("Сидоров", "555-555");
        testBook.add("Сидоров", "666-666");
        testBook.add("Петров", "777-777");

        testBook.get("Иванов");
        testBook.get("Петров");
        testBook.get("Сидоров");
    }

}

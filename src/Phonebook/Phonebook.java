package Phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    public Map<String, List<String>> book = new HashMap<>();

    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook();
        phoneBook.add("Рыжов", "+7-926-678-90-12");
        phoneBook.add("Рыжов", "+7-950-789-01-23");
        phoneBook.add("Комлева", "+7-999-890-12-34");
        phoneBook.add("Елова", "+7-915-901-23-45");

        phoneBook.get("Рыжов");
    }


    public void add(String surname, String number) {
        List<String> phoneNumbers;
        if (!book.containsKey(surname)) {
            phoneNumbers = new ArrayList<>();
            phoneNumbers.add(number);
            book.put(surname, phoneNumbers);
        } else {
            book.get(surname).add(number);
        }
    }

    public void get(String surname) {
        System.out.println("Номера телефонов для фамилии " + surname + " " + book.get(surname));
    }
}

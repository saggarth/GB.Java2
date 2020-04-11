package lesson_3;

import java.util.*;

public class PhoneBook {
    Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone){
        ArrayList<String> phoneNumber;
        if (!phoneBook.containsKey(name)){
            phoneBook.put(name, phoneNumber = new ArrayList<>());
        } else {
            phoneNumber = phoneBook.get(name);
        }
        phoneNumber.add(phone);
    }

    public void get(String name){
        System.out.println(name + " " + phoneBook.get(name));
    }
}
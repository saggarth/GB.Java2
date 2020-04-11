package lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> wordsArray = new ArrayList<>();
        Map<String, Integer> words = new HashMap<>();

        wordsArray.add("стадион");
        wordsArray.add("бумага");
        wordsArray.add("фломастер");
        wordsArray.add("велосипед");
        wordsArray.add("команда");
        wordsArray.add("автобус");
        wordsArray.add("стадион");
        wordsArray.add("пират");
        wordsArray.add("бумага");
        wordsArray.add("автобус");
        wordsArray.add("стадион");
        wordsArray.add("бумага");
        wordsArray.add("торт");
        wordsArray.add("автобус");

        //System.out.println(wordsArray);
        for (int i = 0; i < wordsArray.size(); i++) {
            String tempWord = wordsArray.get(i);
            if (!words.containsKey(tempWord)){
                words.put(tempWord, 1);
            } else {
                words.put(tempWord, words.get(tempWord) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry: words.entrySet()) {
            System.out.println("Слово - " + entry.getKey() + ", повторений - " + entry.getValue());
        }
    }
}
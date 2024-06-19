package Array;

import java.util.*;

public class Array {
    public static void main(String[] args) {
        String[] words = {"Солнце", "Природа", "Дождь", "Природа", "Тишина", "Природа", "Тишина", "Дождь", "Облако", "Звезды", "Природа", "Солнце", "Дождь", "Звезды", "Тишина"};
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        Map<String, Integer> wordCount = new HashMap<>();

        System.out.println(uniqueWords);
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (String word : wordCount.keySet()) {
            System.out.println("Слово \"" + word + "\"" + " встречается " + wordCount.get(word) + " раз(а).");
        }
    }
}

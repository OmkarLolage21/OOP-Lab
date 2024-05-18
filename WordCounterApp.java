package FinalOOPLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WordCounter {

    public Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        if (text == null || text.isEmpty()) {
            return wordCountMap;
        }

        String[] words = text.toLowerCase().split("[\\W_]+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordCountMap;
    }
}

public class WordCounterApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = scanner.nextLine();

        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> wordCounts = wordCounter.countWords(text);

        System.out.println("Word counts:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}

package com.javalesson.collections.map;

import java.util.*;

public class MapLauncher {
    public static void main(String[] args) {
        Map<String, Integer> wordMap = new HashMap<>();
        System.out.println("Введите текст");
        Scanner scanner = new Scanner(System.in);
        String textConsole = scanner.nextLine();
        String[] tokens = textConsole.split(" ");
        for (String token : tokens) {
            String word = token.toLowerCase();
            Integer count = wordMap.get(word);
            if (count == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, count + 1);
            }

        }
        NavigableSet<WordWrapper> wordWrappers = convertToSet(wordMap);
        printSet(wordWrappers);

    }

    private static void printSet(NavigableSet<WordWrapper> wordWrappers) {
        for (WordWrapper wordWrapper: wordWrappers){
            System.out.println(wordWrapper);
        }
    }

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> wordMap) {
        NavigableSet<WordWrapper> wordSet = new TreeSet<>();
        Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
        for (Map.Entry<String, Integer> e : entries) {
            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
        }
        return new TreeSet<>(wordSet);
    }


}

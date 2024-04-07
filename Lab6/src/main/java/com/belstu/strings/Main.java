package com.belstu.strings;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "Sample of text is here. We won't read it from file. This is another sentence. Yet another sentence. This is the last sentence of the text.";
        //2
        String[] givenText = text.split("\\.");
        Arrays.sort(givenText, Comparator.comparingInt(s -> s.split("\\s+").length));
        System.out.println(Arrays.toString(givenText));

        // 3
        String[] sentences = text.split("\\.");
        String[] firstSentenceWords = sentences[0].toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");
        String otherSentences = String.join(" ", Arrays.copyOfRange(sentences, 1, sentences.length)).toLowerCase().replaceAll("[^a-z ]", "");
        for (String word : firstSentenceWords) {
            if (!otherSentences.contains(word)) {
                System.out.println(word);
                break;
            }
        }
        // 8
        List<String> words = Arrays.stream(text.split("\\s+"))
                .filter(word -> word.matches("^[aeiou].*"))
                .sorted(Comparator.comparing(word -> word.replaceAll("[aeiou]", "")))
                .collect(Collectors.toList());
        System.out.println(words);

        // 9
        char letter = 'a';
        words = Arrays.stream(text.split("\\s+"))
                .sorted(Comparator.comparing((String word) -> word.chars().filter(ch -> ch == letter).count()).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println(words);

        // 12.
        int length = 6;
        String result = Arrays.stream(text.split("\\s+"))
                .filter(word -> word.length() != length || word.matches("^[aeiouAEIOU].*"))
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
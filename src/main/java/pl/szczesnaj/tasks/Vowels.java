package pl.szczesnaj.tasks;

import java.util.Set;
import java.util.stream.IntStream;

class Vowels {
    public int check(String sentence) {

        if (sentence == null) return 0;
        String normalized = sentence.toLowerCase();
        String vowels = "aeiouy";
        return (int) normalized
                .chars()
                .filter(c -> vowels.indexOf(c) != -1)
                .count();
    }

    public int checks(String sentence) {
        if (sentence == null) return 0;
        String normalized = sentence.toLowerCase();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'y');
        return (int) IntStream.rangeClosed(0, sentence.length() - 1)
                .filter(n -> vowels.contains(normalized.charAt(n)))
                .count();
    }
}


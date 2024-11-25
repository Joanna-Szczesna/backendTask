package pl.szczesnaj.tasks;

import java.util.stream.IntStream;

class Palindrome {

    boolean check(String word) {
        if (word == null) {
            return false;
        }
        String normalized = word.toLowerCase();
        int middleLetter = normalized.length() / 2;

        return IntStream.range(0, middleLetter).allMatch(i ->
                normalized.charAt(i) == normalized.charAt(normalized.length() - 1 - i));
    }

    boolean checkByLoop(String word) {
        if (word == null) {
            return false;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            char inspectedFirst = Character.toLowerCase(word.charAt(i));
            char inspectedSecond = Character.toLowerCase(word.charAt(word.length() - i - 1));

            if (inspectedFirst != inspectedSecond) {
                return false;
            }
        }
        return true;
    }
    boolean checkByStringBuilder(String word) {
        if (word == null) {
            return false;
        }
        String normalized = word.toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();

        return normalized.equals(reversed);
    }
}

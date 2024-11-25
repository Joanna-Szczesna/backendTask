package pl.szczesnaj.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VowelsTest {
    @Test
    void nullString_returnZero() {
        Vowels v = new Vowels();
        int numberOfVowel = v.check(null);

        assert(numberOfVowel == 0);
    }
    @Test
    void wordHello_returnTwo() {
        Vowels v = new Vowels();
        int numberOfVowel = v.check("Hello");

        assert(numberOfVowel == 2);
    }
    @Test
    void sentenceWithTenVowels_returnTen() {
        Vowels v = new Vowels();
        int numberOfVowel = v.check(" there is a quiet Mouse");

        assert(numberOfVowel == 10);
    }


}
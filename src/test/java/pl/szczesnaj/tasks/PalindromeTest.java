package pl.szczesnaj.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void emptyString_returnTrue() {
        Palindrome p = new Palindrome();
        boolean isPalindrome = p.check("");

        assertTrue(isPalindrome);
    }

    @Test
    void nullString_returnFalse() {
        Palindrome p = new Palindrome();
        boolean isPalindrome = p.check(null);

        assertFalse(isPalindrome);
    }

    @Test
    void nonPalindrome_returnFalse() {
        Palindrome p = new Palindrome();
        boolean isPalindrome = p.check("wifi");

        assertFalse(isPalindrome);
    }
    @Test
    void wordWithDifferentSizeOfLetter_isPalindrome_returnTrue() {
        Palindrome p = new Palindrome();
        boolean isPalindrome = p.check("madaM");

        assertTrue(isPalindrome);
    }
}
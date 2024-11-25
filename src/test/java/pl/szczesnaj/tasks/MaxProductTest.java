package pl.szczesnaj.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProductTest {

    @Test
    void onlyOneNumber_returnIntegerMinValue() {
        MaxProduct maxProduct = new MaxProduct();
        int[] numbers = {5};
        int result = maxProduct.count(numbers);

        assertEquals(result, Integer.MIN_VALUE);
    }

    @Test
    void positiveNumbers_returnMax() {
        MaxProduct maxProduct = new MaxProduct();
        int[] numbers = {5, 3, 2, 5, 7, 0, 1};
        int result = maxProduct.count(numbers);

        assertEquals(result, 35);
    }

    @Test
    void negativeNumbers_returnMax() {
        MaxProduct maxProduct = new MaxProduct();
        int[] numbers = {-2, -1, -3, 4, -8, 0};
        int result = maxProduct.count(numbers);

        assertEquals(result, 24);
    }
}
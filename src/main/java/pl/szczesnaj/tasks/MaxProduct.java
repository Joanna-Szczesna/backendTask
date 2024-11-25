package pl.szczesnaj.tasks;

import java.util.Arrays;

class MaxProduct {

    int count(int[] numbers) {
        int max = Integer.MIN_VALUE;
        if (numbers == null || numbers.length < 2) {
            return max;
        }
        Arrays.sort(numbers);
        int len = numbers.length;

        return Math.max(numbers[0] * numbers[1], numbers[len - 1] * numbers[len - 2]);
    }

    int count2(int[] numbers) {
        int max = Integer.MIN_VALUE;
        if (numbers == null || numbers.length < 2) {
            return max;
        }

        for (int i = 0; i < (numbers.length); i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int result = numbers[i] * numbers[j];
                if (result > max) {
                    max = result;
                }
            }
        }
        return max;
    }
}

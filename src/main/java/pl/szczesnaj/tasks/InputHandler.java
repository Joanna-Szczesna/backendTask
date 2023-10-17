package pl.szczesnaj.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class InputHandler {
    static List<Integer> getNumberListFromInput() {
        Scanner scanner = getUserInput();
        String stringNumbers = removeNonNumericCharacter(scanner.nextLine());
        return Arrays.stream(
                        stringNumbers.split("\\s+"))
                .map(Integer::parseInt)
                .toList();
    }

    private static Scanner getUserInput() {
        return new Scanner(System.in);
    }

    private static String removeNonNumericCharacter(String rawInput) {
        return rawInput
                .replaceAll("[^ \\d-]", "");
    }
}

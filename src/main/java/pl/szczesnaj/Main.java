package pl.szczesnaj;

import pl.szczesnaj.tasks.TasksFacade;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final TasksFacade facade = new TasksFacade();

    public static void main(String[] args) {

        String solutionTaskOne = runTaskOne();
        System.out.println(solutionTaskOne);

        String solutionTaskTwo = runTaskTwo();
        System.out.println(solutionTaskTwo);
    }

    private static String runTaskOne() {
        System.out.println("Task1\nprovide integers:");
        return facade.solutionTaskOne(getNumberListFromInput(getUserInput()));
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return removeNonNumericCharacter(scanner.nextLine());
    }

    private static String runTaskTwo() {
        System.out.println("Task2\nprovide integers:");
        return facade.solutionTaskTwo(getNumberListFromInput(getUserInput()));
    }

    private static String removeNonNumericCharacter(String rawInput) {
        return rawInput
                .replaceAll("[^ \\d-]", "")
                .replaceAll("\\s{2,}", " ");
    }

    private static List<Integer> getNumberListFromInput(String stringNumbers) {
        return Arrays.stream(
                        stringNumbers.split(" "))
                .map(Integer::parseInt)
                .toList();
    }
}
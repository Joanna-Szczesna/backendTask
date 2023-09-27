package pl.szczesnaj.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class TaskTwo {
    final String NO_PAIRS = "No pairs";

    String solution(List<Integer> inputNumbers) {
        if (inputNumbers == null || inputNumbers.isEmpty()) {
            return NO_PAIRS;
        }

        List<String> pairs = findPairs(inputNumbers);
        if (pairs.isEmpty()) {
            return NO_PAIRS;
        }

        return pairs.stream()
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    List<String> findPairs(List<Integer> inputNumbers) {
        List<Integer> orderedNumbers = sortNonNullNumbers(inputNumbers);
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < orderedNumbers.size(); i++) {
            for (int j = i + 1; j < orderedNumbers.size(); j++) {
                int sum = orderedNumbers.get(i) + orderedNumbers.get(j);
                if (sum == 13) {
                    pairs.add(orderedNumbers.get(i) + " " + orderedNumbers.get(j));
                }
                if(sum > 13) {
                    break;
                }
            }
        }
        return pairs;
    }

    private List<Integer> sortNonNullNumbers(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.naturalOrder())
                .toList();
    }
}

package pl.szczesnaj.tasks;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;

class TaskOne {

    String solution(List<Integer> inputNumbers) {
        List<Integer> orderedDistinctElements = getDistinctOrderedElements(inputNumbers);

        return resultFormatter(countInput(inputNumbers),
                orderedDistinctElements,
                getMinElement(orderedDistinctElements),
                getMaxValue(orderedDistinctElements));
    }

    String resultFormatter(int count,
                           List<Integer> orderedDistinctElements,
                           OptionalInt minValue,
                           OptionalInt maxValue) {
        String min = minValue.isPresent() ? String.valueOf(minValue.getAsInt()) : "";
        String max = maxValue.isPresent() ? String.valueOf(maxValue.getAsInt()) : "";
        return ""
                + orderedDistinctElements.stream().map(Object::toString)
                .collect(Collectors.joining(" ")) + System.lineSeparator()
                + "count: " + count + System.lineSeparator()
                + "distinct: " + orderedDistinctElements.size() + System.lineSeparator()
                + "min: " +  min + System.lineSeparator()
                + "max: " + max;
    }

    int countInput(List<Integer> inputNumbers) {
        if (inputNumbers == null) {
            return 0;
        }
        return inputNumbers.size();
    }

    List<Integer> getDistinctOrderedElements(List<Integer> inputNumbers) {
        if (inputNumbers == null) {
            return List.of();
        }
        return inputNumbers.parallelStream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    OptionalInt getMinElement(List<Integer> orderedNumbers) {
        if (orderedNumbers.isEmpty()) {
            return OptionalInt.empty();
        }
        int minValue = orderedNumbers.stream().findFirst().get();

        return OptionalInt.of(minValue);
    }

    OptionalInt getMaxValue(List<Integer> orderedNumbers) {
        if (orderedNumbers.isEmpty()) {
            return OptionalInt.empty();
        }
        int maxValue = orderedNumbers.get(orderedNumbers.size() - 1);

        return OptionalInt.of(maxValue);
    }
}

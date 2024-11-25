package pl.szczesnaj.tasks;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class FizzBuzz {

    public Stream<String> run(Integer start, Integer end) {
        if (start == null || end == null || start > end) {
            return Stream.empty();
        }
        return IntStream.rangeClosed(start, end).mapToObj(n -> {
            if (n % 15 == 0) return "FizzBuzz";
            if (n % 3 == 0) return "Fizz";
            if (n % 5 == 0) return "Buzz";
            return String.valueOf(n);
        });

    }
}

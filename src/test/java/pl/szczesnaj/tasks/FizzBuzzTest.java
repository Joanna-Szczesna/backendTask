package pl.szczesnaj.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }


    @Test
    void whenNumericalRangeContainsNull_returnEmptyStream() {
        Integer start = 1;
        Integer end = null;

        Stream<String> result = fizzBuzz.run(start, end);
        boolean isStreamEmpty = result.findAny().isEmpty();

        assertTrue(isStreamEmpty);
    }

    @Test
    void whenNumericalRangeContainsSameNumbers_returnOneResult() {
        Integer start = 1;
        Integer end = 1;

        Stream<String> resultStream = fizzBuzz.run(start, end);
        List<String> result = resultStream.toList();
        List<String> expected = List.of("1");

        assert (result.equals(expected));
    }

    @Test
    void whenNumericalRangeSecondNumberIsSmaller_returnEmptyStream() {
        Integer start = 6;
        Integer end = 1;

        Stream<String> resultStream = fizzBuzz.run(start, end);
        boolean isStreamEmpty = resultStream.findAny().isEmpty();

        assertTrue(isStreamEmpty);
    }

    @Test
    void whenNumericalRangeIsCorrect_returnFizzBuzz() {
        Integer start = 1;
        Integer end = 16;

        Stream<String> resultStream = fizzBuzz.run(start, end);
        List<String> result = resultStream.toList();

        List<String> expected = List.of("1", "2", "Fizz", "4", "Buzz",
                "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "13", "14", "FizzBuzz", "16");

        assert(result.equals(expected));
    }


}
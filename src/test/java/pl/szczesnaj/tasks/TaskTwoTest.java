package pl.szczesnaj.tasks;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth8.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaskTwoTest {
    TaskTwo task;

    @BeforeEach
    void setUp() {
        task = new TaskTwo();
    }

    @Nested
    class NoPairs {
        @Test
        void ifListIsNull_returnNoPairsStatement() {
            List<Integer> nullList = null;
            String returnStatement = task.solution(nullList);

            assertEquals("No pairs", returnStatement);
        }

        @Test
        void ifListIsEmpty_returnNoPairStatement() {
            List<Integer> emptyList = List.of();
            String returnStatement = task.solution(emptyList);

            assertEquals("No pairs", returnStatement);
        }

        @Test
        void ifNoPairFound_returnNoPairStatement() {
            List<Integer> numberList = List.of(1, 3, 5, 7);
            String returnStatement = task.solution(numberList);

            assertEquals("No pairs", returnStatement);
        }
    }

    @Test
    void whenInputListContainsNull_filterIt() {
        List<Integer> inputNumbers = Lists.newArrayList(1, 2, 10, 7, 5, 3, null, 6, 6, 13, 0);
        List<String> pairs = task.findPairs(inputNumbers);

        assertEquals(4, pairs.size());
    }

    @Nested
    class Full {
        @Test
        void sample() {
            List<Integer> inputNumbers = List.of(1, 2, 10, 7, 5, 3, 6, 6, 13, 0);
            String returnStatement = task.solution(inputNumbers);

            assertThat(returnStatement.lines()).contains("0 13");
            assertThat(returnStatement.lines()).contains("3 10");
            assertThat(returnStatement.lines()).contains("6 7");
        }
    }
}
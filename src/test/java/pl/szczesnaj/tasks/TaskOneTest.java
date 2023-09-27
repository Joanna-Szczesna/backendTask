package pl.szczesnaj.tasks;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalInt;

import static com.google.common.truth.Truth8.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaskOneTest {
    TaskOne task;
    @BeforeEach
    void setUp() {
        task = new TaskOne();
    }

    @Nested
    class DistinctElements {
        @Test
        void whenInputListIsNull_returnEmptyList() {
            List<Integer> inputNumbers = null;
            List<Integer> outputNumbers = task.getDistinctOrderedElements(inputNumbers);

            boolean isEmpty = outputNumbers.isEmpty();
            assertTrue(isEmpty);
        }

        @Test
        void whenInputListIsEmpty_returnEmptyList() {
            List<Integer> inputNumbers = List.of();
            List<Integer> outputNumbers = task.getDistinctOrderedElements(inputNumbers);

            boolean isEmpty = outputNumbers.isEmpty();
            assertTrue(isEmpty);
        }

        @Test
        void whenInputHasSameElements_returnOnlyDistinctElementsInAscendingOrder() {
            List<Integer> inputNumbers = List.of(1, 10, 20, 20, 2, 5);
            List<Integer> outputNumbers = task.getDistinctOrderedElements(inputNumbers);
            List<Integer> expectedNumbers = List.of(1, 2, 5, 10, 20);

            assertEquals(5, outputNumbers.size());
            assertEquals(expectedNumbers, outputNumbers);
        }

        @Test
        void whenInputContainsNullElements_removeNullElements() {
            List<Integer> inputNumbers = Lists.newArrayList(1, 10, null, null, 2);

            List<Integer> outputNumbers = task.getDistinctOrderedElements(inputNumbers);
            List<Integer> expectedNumbers = List.of(1, 2, 10);

            assertEquals(3, outputNumbers.size());
            assertEquals(expectedNumbers, outputNumbers);
        }
    }

    @Nested
    class Count {
        @Test
        void whenInputListIsEmpty_returnZeroSize() {
            List<Integer> inputNumbers = List.of();
            int inputListSize = task.countInput(inputNumbers);

            assertEquals(0, inputListSize);
        }

        @Test
        void whenInputListIsNull_returnZeroSize() {
            List<Integer> inputNumbers = null;
            int inputListSize = task.countInput(inputNumbers);

            assertEquals(0, inputListSize);
        }

        @Test
        void whenInputListContainsNull_CountItAsValue() {
            List<Integer> inputNumbers = Lists.newArrayList(1, null, 2);
            int inputListSize = task.countInput(inputNumbers);

            assertEquals(3, inputListSize);
        }
    }

    @Nested
    class MinimumValue {
        @Test
        void whenInputListIsEmpty_returnNoValue() {
            List<Integer> inputNumbers = List.of();
            OptionalInt minValue = task.getMinElement(inputNumbers);

            assertEquals(OptionalInt.empty(), minValue);
        }

        @Test
        void whenInputHasSameMinimumElements_returnOneOfThem() {
            List<Integer> inputNumbers = List.of(1, 1, 2, 5);
            OptionalInt minValue = task.getMinElement(inputNumbers);

            assertEquals(OptionalInt.of(1), minValue);
        }

        @Test
        void whenOrderedListHasOneElement_returnIt() {
            List<Integer> inputNumbers = List.of(5);
            OptionalInt minValue = task.getMinElement(inputNumbers);

            assertEquals(OptionalInt.of(5), minValue);
        }
    }

    @Nested
    class MaximumValue {
        @Test
        void whenOrderedListIsEmpty_returnNoValue() {
            List<Integer> naturalOrderedList = List.of();
            OptionalInt maxValue = task.getMaxValue(naturalOrderedList);

            assertEquals(OptionalInt.empty(), maxValue);
        }

        @Test
        void whenOrderedListContainsOneElement_returnIt() {
            List<Integer> naturalOrderedList = List.of(5);
            OptionalInt maxValue = task.getMaxValue(naturalOrderedList);

            assertEquals(OptionalInt.of(5), maxValue);
        }

        @Test
        void naturalOrderedList_returnLastElement() {
            List<Integer> naturalOrderedList = List.of(4, 5, 6);
            OptionalInt maxValue = task.getMaxValue(naturalOrderedList);

            assertEquals(OptionalInt.of(6), maxValue);
        }
    }

    @Nested
    class ListBio {
        @Test
        void returnStatementIncludeAllElements() {
            List<Integer> inputNumbers = List.of(1, 10, 20, 20, 2, 5);
            String returnStatement = task.solution(inputNumbers);

            assertThat(returnStatement.lines()).contains("1 2 5 10 20");
            assertThat(returnStatement.lines()).contains("count: 6");
            assertThat(returnStatement.lines()).contains("distinct: 5");
            assertThat(returnStatement.lines()).contains("min: 1");
            assertThat(returnStatement.lines()).contains("max: 20");
        }

        @Test
        void emptyListReturnStatementIncludeAllElements() {
            List<Integer> inputNumbers = List.of();
            String returnStatement = task.solution(inputNumbers);

            assertThat(returnStatement.lines()).contains("count: 0");
            assertThat(returnStatement.lines()).contains("distinct: 0");
            assertThat(returnStatement.lines()).contains("min: ");
            assertThat(returnStatement.lines()).contains("max: ");
        }

        @Test
        void oneElementList() {
            List<Integer> inputNumbers = List.of(5);
            String returnStatement = task.solution(inputNumbers);

            assertThat(returnStatement.lines()).contains("count: 1");
            assertThat(returnStatement.lines()).contains("distinct: 1");
            assertThat(returnStatement.lines()).contains("min: 5");
            assertThat(returnStatement.lines()).contains("max: 5");
        }

        @Test
        void inputListWithNulls() {
            List<Integer> inputNumbers = Lists.newArrayList(5,7,-6,null, 8, null,-6, 1);
            String returnStatement = task.solution(inputNumbers);

            assertThat(returnStatement.lines()).contains("-6 1 5 7 8");
            assertThat(returnStatement.lines()).contains("count: 8");
            assertThat(returnStatement.lines()).contains("distinct: 5");
            assertThat(returnStatement.lines()).contains("min: -6");
            assertThat(returnStatement.lines()).contains("max: 8");
        }
    }
}
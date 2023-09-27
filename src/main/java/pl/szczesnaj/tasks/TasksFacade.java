package pl.szczesnaj.tasks;

import java.util.List;

public class TasksFacade {
    private final TaskOne taskOne;
    private final TaskTwo taskTwo;

    public TasksFacade() {
        this.taskOne = new TaskOne();
        this.taskTwo = new TaskTwo();
    }

    public String solutionTaskOne(List<Integer> inputList) {
        return taskOne.solution(inputList);
    }
    public String solutionTaskTwo(List<Integer> inputList) {
        return taskTwo.solution(inputList);
    }
}

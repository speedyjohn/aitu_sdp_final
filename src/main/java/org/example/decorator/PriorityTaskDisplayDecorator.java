package org.example.decorator;

import org.example.model.Task;
// Extra line with green Priority
public class PriorityTaskDisplayDecorator extends TaskDisplayDecorator {
    private Task task;
    // ANSI escape codes
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

    public PriorityTaskDisplayDecorator(TaskDisplay decoratedTaskDisplay, Task task) {
        super(decoratedTaskDisplay);
        this.task = task;
    }

    @Override
    public void display() {
        super.display();
        displayPriority();
    }

    private void displayPriority() {
        System.out.println(GREEN + "Priority: " + task.getPriority() + RESET);
    }
}

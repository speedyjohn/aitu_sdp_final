package org.example.decorator;

import org.example.model.Task;
// Extra line with green Date
public class DateTaskDisplayDecorator extends TaskDisplayDecorator {
    private Task task;
    // ANSI escape codes
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

    public DateTaskDisplayDecorator(TaskDisplay decoratedTaskDisplay, Task task) {
        super(decoratedTaskDisplay);
        this.task = task;
    }

    @Override
    public void display() {
        super.display();
        displayDate();
    }

    private void displayDate() {
        System.out.println(GREEN + "Due Date: " + task.getDueDate() + RESET);
    }
}

package org.example.decorator;

import org.example.model.Task;

public class DescriptionTaskDisplayDecorator extends TaskDisplayDecorator {
    private Task task;
    // ANSI escape codes
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

    public DescriptionTaskDisplayDecorator(TaskDisplay decoratedTaskDisplay, Task task) {
        super(decoratedTaskDisplay);
        this.task = task;
    }

    @Override
    public void display() {
        super.display();
        displayDescription();
    }

    private void displayDescription() {
        System.out.println(GREEN + "Description: " + task.getDescription() + RESET);
    }
}

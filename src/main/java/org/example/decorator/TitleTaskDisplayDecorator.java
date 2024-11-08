package org.example.decorator;

import org.example.model.Task;
// Extra line with green Title
public class TitleTaskDisplayDecorator extends TaskDisplayDecorator {
    private Task task;
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

    public TitleTaskDisplayDecorator(TaskDisplay decoratedTaskDisplay, Task task) {
        super(decoratedTaskDisplay);
        this.task = task;
    }

    @Override
    public void display() {
        super.display();
        displayTitle();
    }

    private void displayTitle() {
        System.out.println(GREEN + "Title: " + task.getName() + RESET);
    }
}

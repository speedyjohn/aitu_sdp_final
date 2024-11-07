package org.example.decorator;

import org.example.model.Task;
// No extra lines
public class SimpleTaskDisplay implements TaskDisplay {
    private Task task;

    public SimpleTaskDisplay(Task task) {
        this.task = task;
    }

    @Override
    public void display() {
        System.out.println("Task with id " + task.getId() + ":\n" + task);
    }
}

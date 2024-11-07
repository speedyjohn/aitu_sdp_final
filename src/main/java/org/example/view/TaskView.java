package org.example.view;

import org.example.model.DBHelper;
import org.example.model.Task;

import java.sql.SQLException;
import java.util.List;

public class TaskView {
    private static DBHelper dbHelper;

    public TaskView() throws SQLException {
        this.dbHelper = DBHelper.getInstance();
    }
    public void displayTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println("Task with id " + task.getId() + ":\n" + task);
        }
    }

    public void displayTask(Task task) {
        System.out.println("Task with id " + task.getId() + ":\n" + task);
    }

    public void displayNull() {
        System.out.println("Task is not found");
    }

    public void displayCreated(Task task) {
        System.out.println("New task with id " + task.getId() + " created:\n" + task);
    }

    public void displayUpdated(Task task) {
        System.out.println("Task with id " + task.getId() + " updated:\n" + task);
    }

    public void displayDeleted(Task task) {
        System.out.println("Task with id " + task.getId() + " deleted:\n" + task);
    }

    public void error() {
        System.out.println("Unexpected error");
    }
}

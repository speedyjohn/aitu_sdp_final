package org.example.view;

import org.example.model.DBHelper;
import org.example.model.Task;

import java.sql.SQLException;
import java.util.List;

public class TaskView {
    public static void displayTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println("Task with id " + task.getId() + ":\n" + task);
        }
    }

    public static void displayTask(Task task) {
        System.out.println("Task with id " + task.getId() + ":\n" + task);
    }

    public static void displayNull() {
        System.out.println("Task is not found");
    }

    public static void displayCreated(Task task) {
        System.out.println("New task with id " + task.getId() + " created:\n" + task);
    }

    public static void displayUpdated(Task task) {
        System.out.println("Task with id " + task.getId() + " updated:\n" + task);
    }

    public static void displayDeleted(Task task) {
        System.out.println("Task with id " + task.getId() + " deleted:\n" + task);
    }

    public static void error() {
        System.out.println("Unexpected error");
    }
}

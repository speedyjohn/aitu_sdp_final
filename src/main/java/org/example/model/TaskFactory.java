package org.example.model;

import java.sql.SQLException;
import java.time.LocalDate;
// Class for creating new objects
// Implements Factory Patter
// Gives opportunities to different creation scenarios
// Also gives opportunities to validate data
public class TaskFactory {
    private static DBHelper dbHelper;

    public TaskFactory() throws SQLException {
        this.dbHelper = DBHelper.getInstance();
    }
    
    public static Task createTask(String title, String description, String dueDate, String priority) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (dueDate == null || dueDate.isEmpty()) {
            throw new IllegalArgumentException("Date cannot be empty");
        }
        if (priority == null || priority.isEmpty()) {
            throw new IllegalArgumentException("Priority cannot be empty");
        }
        Task task = new Task(title, description, LocalDate.parse(dueDate), priority);
        dbHelper.addTask(task);
        return task;
    }

    public static Task createTaskToday(String title, String description, String priority) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (priority == null || priority.isEmpty()) {
            throw new IllegalArgumentException("Priority cannot be empty");
        }
        Task task = new Task(title, description, LocalDate.now(), priority);
        dbHelper.addTask(task);
        return task;
    }

    public static Task createTaskTomorrow(String title, String description, String priority) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (priority == null || priority.isEmpty()) {
            throw new IllegalArgumentException("Priority cannot be empty");
        }
        Task task = new Task(title, description, LocalDate.now().plusDays(1), priority);
        dbHelper.addTask(task);
        return task;
    }

    public static Task createTaskCustom(String title, String description, String priority, int days) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (priority == null || priority.isEmpty()) {
            throw new IllegalArgumentException("Priority cannot be empty");
        }
        Task task = new Task(title, description, LocalDate.now().plusDays(days), priority);
        dbHelper.addTask(task);
        return task;
    }
}

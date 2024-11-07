package org.example.service;

import org.example.model.DBHelper;
import org.example.model.Task;
import org.example.model.TaskFactory;
import org.sqlite.core.DB;

import java.sql.SQLException;
import java.util.List;

public class TaskService {
    private static DBHelper dbHelper;
    private static TaskFactory taskFactory;

    static {
        try {
            dbHelper = DBHelper.getInstance();
            taskFactory = new TaskFactory();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Task createTask(String title, String description, String dueDate, String priority) {
        return taskFactory.createTask(title, description, dueDate, priority);
    }

    public static Task createTaskToday(String title, String description, String dueDate) {
        return taskFactory.createTaskToday(title, description, dueDate);
    }

    public static Task createTaskTomorrow(String title, String description, String dueDate) {
        return taskFactory.createTaskTomorrow(title, description, dueDate);
    }

    public static Task createTaskCustom(String title, String description, String dueDate, int days) {
        return taskFactory.createTaskCustom(title, description, dueDate, days);
    }

    public static Task updateTask(Task task, int id) {
        return dbHelper.updateTask(task, id);
    }

    public static Task deleteTask(int id) {
        return dbHelper.deleteTask(id);
    }

    public static Task getTask(int id) {
        return dbHelper.getTask(id);
    }

    public static List<Task> getAllTasks() {
        return dbHelper.getAllTasks();
    }
}

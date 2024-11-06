package org.example;

import org.example.model.DBHelper;
import org.example.model.Task;
import org.example.model.TaskFactory;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        Task task2 = new Task("Task2", "Description", LocalDate.now(), "High");
        TaskFactory factory = new TaskFactory();
        factory.createTask("Task2", "Description", LocalDate.of(2024, 12, 01).toString(), "High");
        factory.createTaskToday("Task2", "Description", "High");
        factory.createTaskTomorrow("Task2", "Description", "High");
        factory.createTaskCustom("Task2", "Description", "High", 10);
    }
}
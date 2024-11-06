package org.example;

import org.example.model.Task;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Task task = new Task(1, "Task", "Description", 2024, 12, 1, "High");
        System.out.println(task.toString());
    }
}
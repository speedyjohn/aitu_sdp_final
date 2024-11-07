package org.example;

import org.example.Sort.SortByNameDescStrategy;
import org.example.Sort.SortStrategy;
import org.example.controller.TaskController;
import org.example.model.Task;
import org.example.service.TaskService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        TaskController controller = new TaskController();
        List<Task> tasks = TaskService.getAllTasks();
        SortStrategy sort = new SortByNameDescStrategy();
        List<Task> sortedTasks =  sort.sort(tasks);
        for (Task task : sortedTasks) {
            System.out.println(task);
        }
    }
}
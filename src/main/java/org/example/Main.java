package org.example;

import com.sun.tools.jconsole.JConsoleContext;
import org.example.sort.SortByNameDescStrategy;
import org.example.sort.SortStrategy;
import org.example.controller.TaskController;
import org.example.model.Task;
import org.example.service.TaskService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        TaskController controller = new TaskController();
        Task newTask = new Task("Update", "Desc", LocalDate.now(), "Low");
        controller.update(newTask, 3);
    }
}
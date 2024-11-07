package org.example;

import org.example.controller.TaskController;
import org.example.model.DBHelper;
import org.example.model.Task;
import org.example.model.TaskFactory;
import org.example.view.TaskView;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        TaskController controller = new TaskController();
    }
}
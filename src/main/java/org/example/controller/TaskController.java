package org.example.controller;

import org.example.service.TaskService;
import org.example.sort.SortStrategy;
import org.example.view.TaskView;
import org.example.model.Task;

import java.sql.SQLException;
import java.util.List;

public class TaskController {

    public void create(int option, String title, String description, String dueDate, String priority, int days) {
        switch (option) {
            case 1:
                Task task = TaskService.createTask(title, description, dueDate, priority);
                TaskView.displayCreated(task);
                break;
            case 2:
                Task taskToday = TaskService.createTaskToday(title, description, priority);
                TaskView.displayCreated(taskToday);
                break;
            case 3:
                Task taskTomorrow = TaskService.createTaskTomorrow(title, description, priority);
                TaskView.displayCreated(taskTomorrow);
                break;
            case 4:
                Task taskCustom = TaskService.createTaskCustom(title, description, priority, days);
                TaskView.displayCreated(taskCustom);
                break;
            default:
                TaskView.error();
                break;
        }
    }

    public void update(Task task, int id) {
        Task updatedTask = TaskService.updateTask(task, id);
        TaskView.displayUpdated(updatedTask);
    }

    public void delete(int id) {
        Task deletedTask = TaskService.deleteTask(id);
        TaskView.displayDeleted(deletedTask);
    }

    public void getById(int id) {
        Task task = TaskService.getTask(id);
        TaskView.displayTask(task);
    }

    public void getAll(SortStrategy sort) {
        List<Task> tasks = TaskService.getAllTasks();
        TaskView.displayTasks(tasks);
    }
}

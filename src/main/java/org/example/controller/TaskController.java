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

    public void getById(int id, int display) {
        Task task = TaskService.getTask(id);
        switch (display) {
            case 1:
                TaskView.displayTask(task);
                break;
            case 2:
                TaskView.displayTaskAndTitle(task);
                break;
            case 3:
                TaskView.displayTaskAndDescription(task);
                break;
            case 4:
                TaskView.displayTaskAndDate(task);
                break;
            case 5:
                TaskView.displayTaskAndPriority(task);
                break;
            default:
                TaskView.displayTask(task);
                break;
        }
    }

    public void getAll(SortStrategy sort) {
        List<Task> tasks = TaskService.getAllTasks();
        List<Task> sortedTasks = sort.sort(tasks);
        TaskView.displayTasks(sortedTasks);
    }
}

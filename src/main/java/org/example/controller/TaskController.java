package org.example.controller;

import org.example.service.TaskService;
import org.example.view.TaskView;
import org.example.model.Task;

import java.sql.SQLException;
import java.util.List;

public class TaskController {
    private TaskService taskService;
    private TaskView taskView;

    public TaskController() throws SQLException {
        this.taskService = new TaskService();
        this.taskView = new TaskView();
    }

    public void create(int option, String title, String description, String dueDate, String priority, int days) {
        switch (option) {
            case 1:
                Task task = taskService.createTask(title, description, dueDate, priority);
                taskView.displayCreated(task);
                break;
            case 2:
                Task taskToday = taskService.createTaskToday(title, description, priority);
                taskView.displayCreated(taskToday);
                break;
            case 3:
                Task taskTomorrow = taskService.createTaskTomorrow(title, description, priority);
                taskView.displayCreated(taskTomorrow);
                break;
            case 4:
                Task taskCustom = taskService.createTaskCustom(title, description, priority, days);
                taskView.displayCreated(taskCustom);
                break;
            default:
                taskView.error();
                break;
        }
    }

    public void update(Task task, int id) {
        Task updatedTask = taskService.updateTask(task, id);
        taskView.displayUpdated(updatedTask);
    }

    public void delete(int id) {
        Task deletedTask = taskService.deleteTask(id);
        taskView.displayDeleted(deletedTask);
    }

    public void getById(int id) {
        Task task = taskService.getTask(id);
        taskView.displayTask(task);
    }

    public void getAll() {
        List<Task> tasks = taskService.getAllTasks();
        taskView.displayTasks(tasks);
    }
}

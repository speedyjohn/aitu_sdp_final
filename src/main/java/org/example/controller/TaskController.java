package org.example.controller;

import org.example.notification.TaskNotification;
import org.example.service.TaskService;
import org.example.sort.SortStrategy;
import org.example.view.TaskView;
import org.example.model.Task;

import java.util.List;

public class TaskController {
    private TaskService taskService;

    public TaskController() {
        taskService = new TaskService();
        taskService.addObserver(new TaskNotification());
    }

    public void create(int option, String title, String description, String dueDate, String priority, int days) {
        switch (option) {
            case 1:
                Task task = taskService.createTask(title, description, dueDate, priority);
                TaskView.displayCreated(task);
                break;
            case 2:
                Task taskToday = taskService.createTaskToday(title, description, priority);
                TaskView.displayCreated(taskToday);
                break;
            case 3:
                Task taskTomorrow = taskService.createTaskTomorrow(title, description, priority);
                TaskView.displayCreated(taskTomorrow);
                break;
            case 4:
                Task taskCustom = taskService.createTaskCustom(title, description, priority, days);
                TaskView.displayCreated(taskCustom);
                break;
            default:
                TaskView.error();
                break;
        }
    }

    public void update(Task task, int id) {
        Task updatedTask = taskService.updateTask(task, id);
        TaskView.displayUpdated(updatedTask);
    }

    public void delete(int id) {
        Task deletedTask = taskService.deleteTask(id);
        TaskView.displayDeleted(deletedTask);
    }

    public void getById(int id, int display) {
        Task task = taskService.getTask(id);
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
        List<Task> tasks = taskService.getAllTasks();
        List<Task> sortedTasks = sort.sort(tasks);
        TaskView.displayTasks(sortedTasks);
    }
}

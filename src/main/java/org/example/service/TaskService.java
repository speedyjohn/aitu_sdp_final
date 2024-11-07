package org.example.service;

import org.example.model.DBHelper;
import org.example.model.Task;
import org.example.model.TaskFactory;
import org.example.notification.Observable;
import org.example.notification.Observer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// An additional abstraction layer
// Just makes our life easily
public class TaskService implements Observable {
    private List<Observer> observers = new ArrayList<>();
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

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public Task createTask(String title, String description, String dueDate, String priority) {
        return taskFactory.createTask(title, description, dueDate, priority);
    }

    public Task createTaskToday(String title, String description, String dueDate) {
        return taskFactory.createTaskToday(title, description, dueDate);
    }

    public Task createTaskTomorrow(String title, String description, String dueDate) {
        return taskFactory.createTaskTomorrow(title, description, dueDate);
    }

    public Task createTaskCustom(String title, String description, String dueDate, int days) {
        return taskFactory.createTaskCustom(title, description, dueDate, days);
    }

    public Task updateTask(Task task, int id) {
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";
        Task newTask = dbHelper.updateTask(task, id);
        notifyObservers(GREEN + "Task with id " + newTask.getId() + " is updated" + RESET);
        return newTask;
    }

    public Task deleteTask(int id) {
        return dbHelper.deleteTask(id);
    }

    public Task getTask(int id) {
        return dbHelper.getTask(id);
    }

    public List<Task> getAllTasks() {
        return dbHelper.getAllTasks();
    }

}

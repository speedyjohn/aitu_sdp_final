package org.example.notification;

public class TaskNotification implements Observer {
    @Override
    public void update(String message) {
        System.out.println("New notification:\n" + message);
    }
}

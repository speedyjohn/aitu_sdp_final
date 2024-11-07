package org.example.notification;
// Class for notifications
// Implements observer pattern
public class TaskNotification implements Observer {
    @Override
    public void update(String message) {
        System.out.println("New notification:\n" + message);
    }
}

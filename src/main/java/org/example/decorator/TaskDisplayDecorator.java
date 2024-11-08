package org.example.decorator;
// Superclass for display decorators
public abstract class TaskDisplayDecorator implements TaskDisplay {
    protected TaskDisplay decoratedTaskDisplay;

    public TaskDisplayDecorator(TaskDisplay decoratedTaskDisplay) {
        this.decoratedTaskDisplay = decoratedTaskDisplay;
    }

    @Override
    public void display() {
        decoratedTaskDisplay.display();
    }
}

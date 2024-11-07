package org.example.sort;

import org.example.model.Task;

import java.util.Comparator;
import java.util.List;
// Sort by Title in descending order
public class SortByNameDescStrategy implements SortStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getName).reversed());
        return tasks;
    }
}

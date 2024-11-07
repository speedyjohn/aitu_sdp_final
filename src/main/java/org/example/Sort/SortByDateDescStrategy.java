package org.example.Sort;

import org.example.model.Task;

import java.util.Comparator;
import java.util.List;

public class SortByDateDescStrategy implements SortStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDueDate).reversed());
        return tasks;
    }
}

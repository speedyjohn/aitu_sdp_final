package org.example.sort;

import org.example.model.Task;

import java.util.Comparator;
import java.util.List;

public class SortByIdDescStrategy implements SortStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getId).reversed());
        return tasks;
    }
}

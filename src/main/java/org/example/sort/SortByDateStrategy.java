package org.example.sort;

import org.example.model.Task;

import java.util.Comparator;
import java.util.List;
// Sort by Date in ascending order
public class SortByDateStrategy implements SortStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDueDate));
        return tasks;
    }
}

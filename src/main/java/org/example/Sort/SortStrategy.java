package org.example.Sort;

import org.example.model.Task;

import java.util.List;

public interface SortStrategy {
    public void sort(List<Task> tasks);
}

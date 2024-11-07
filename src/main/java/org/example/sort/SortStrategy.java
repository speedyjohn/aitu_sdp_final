package org.example.sort;

import org.example.model.Task;

import java.util.List;

public interface SortStrategy {
    List<Task> sort(List<Task> tasks);
}

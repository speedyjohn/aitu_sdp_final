package org.example.sort;

import org.example.model.Task;

import java.util.List;
// Interface for sort strategies
// Implements Strategy Pattern
public interface SortStrategy {
    List<Task> sort(List<Task> tasks);
}

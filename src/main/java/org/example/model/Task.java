package org.example.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// Task model
@Getter
@Setter
@ToString
public class Task {
    private int id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private String priority;

    public Task(String name, String description, LocalDate dueDate, String priority) {
        this.id = -1;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }
}

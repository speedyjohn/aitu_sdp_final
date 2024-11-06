package org.example.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Task {
    private int id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private String priority;

    public Task(String name, String description, int year, int month, int day, String priority) {
        this.id = -1;
        this.name = name;
        this.description = description;
        this.dueDate = LocalDate.of(year, month, day);
        this.priority = priority;
    }
}

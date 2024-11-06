package org.example.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
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

    public Task(int id, String name, String description, int year, int month, int day, String priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = LocalDate.of(year, month, day);
        this.priority = priority;
    }
}

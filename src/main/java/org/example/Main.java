package org.example;

import com.sun.tools.jconsole.JConsoleContext;
import org.example.decorator.SimpleTaskDisplay;
import org.example.sort.*;
import org.example.controller.TaskController;
import org.example.model.Task;
import org.example.service.TaskService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        TaskController controller = new TaskController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose option:\n1- Get all tasks\n2- Get task by id\n3- Create new task\n4- Update existing task\n5- Delete task");
            int mainOption = scanner.nextInt();
            switch (mainOption) {
                case 1:
                    System.out.println("Choose sort option:\n1- By id(default)\n2- By id desc\n3- By title\n4- By title desc\n5- By date\n6- By date desc\n7- By priority\n8- By priority desc\n");
                    int sortOption = scanner.nextInt();
                    switch (sortOption) {
                        case 1:
                            controller.getAll(new SortByIdStrategy());
                            System.out.println("---------------");
                            break;
                        case 2:
                            controller.getAll(new SortByIdDescStrategy());
                            System.out.println("---------------");
                            break;
                        case 3:
                            controller.getAll(new SortByNameStrategy());
                            System.out.println("---------------");
                            break;
                        case 4:
                            controller.getAll(new SortByNameDescStrategy());
                            System.out.println("---------------");
                            break;
                        case 5:
                            controller.getAll(new SortByDateStrategy());
                            System.out.println("---------------");
                            break;
                        case 6:
                            controller.getAll(new SortByDateDescStrategy());
                            System.out.println("---------------");
                            break;
                        case 7:
                            controller.getAll(new SortByPriorityStrategy());
                            System.out.println("---------------");
                            break;
                        case 8:
                            controller.getAll(new SortByPriorityDescStrategy());
                            System.out.println("---------------");
                            break;
                        default:
                            System.out.println("Incorrect input. Default sort is used.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter task ID:");
                    int taskId = scanner.nextInt();
                    System.out.println("Choose view option:\n1- Default\n2- Highlight title\n3- Highlight description\n4- Highlight date\n5- Highlight priority");
                    int viewOption = scanner.nextInt();
                    switch (viewOption) {
                        case 1:
                            controller.getById(taskId, 1);
                            System.out.println("---------------");
                            break;
                        case 2:
                            controller.getById(taskId, 2);
                            System.out.println("---------------");
                            break;
                        case 3:
                            controller.getById(taskId, 3);
                            System.out.println("---------------");
                            break;
                        case 4:
                            controller.getById(taskId, 4);
                            System.out.println("---------------");
                            break;
                        case 5:
                            controller.getById(taskId, 5);
                            System.out.println("---------------");
                            break;
                        default:
                            System.out.println("Incorrect input. Default view is used.");
                            controller.getById(taskId, 1);
                            System.out.println("---------------");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Choose create option:\n1- Create with custom date\n2- Create with today's date\n3- Create with tomorrow's date\n4- Create with date shift");
                    int createOption = scanner.nextInt();
                    System.out.println("Enter task title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String desc = scanner.nextLine();
                    System.out.println("Enter task date like 2024-01-01: ");
                    String dueDate = scanner.nextLine();
                    System.out.println("Enter task priority: ");
                    String priority = scanner.nextLine();
                    int days = 0;
                    if (createOption == 4) {
                        System.out.println("Enter days shift: ");
                        days = scanner.nextInt();
                    }
                    controller.create(createOption, title, desc, dueDate, priority, days);
                    System.out.println("---------------");
                    break;
                case 4:
                    System.out.println("Enter task id to update: ");
                    int taskToUpdateId = scanner.nextInt();
                    System.out.println("Enter task title: ");
                    scanner.nextLine();
                    String taskToUpdateTitle = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String taskToUpdateDesc = scanner.nextLine();
                    System.out.println("Enter task date like 2024-01-01: ");
                    String taskToUpdateDueDate = scanner.nextLine();
                    System.out.println("Enter task priority: ");
                    String taskToUpdatePriority = scanner.nextLine();
                    Task updatedTask = new Task(taskToUpdateTitle, taskToUpdateDesc, LocalDate.parse(taskToUpdateDueDate), taskToUpdatePriority);
                    controller.update(updatedTask, taskToUpdateId);
                    System.out.println("---------------");
                    break;
                case 5:
                    System.out.println("Enter task id to delete: ");
                    int taskToDeleteId = scanner.nextInt();
                    controller.delete(taskToDeleteId);
                    System.out.println("---------------");
                    break;
                default:
                    System.out.println("Incorrect output");
                    System.out.println("---------------");
            }
        }
    }
}
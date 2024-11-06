package org.example.model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBHelper {
    private static DBHelper instance;
    private static final String url = "jdbc:sqlite:tasks.db";

    // Метод для получения единственного экземпляра DBHelper
    public static DBHelper getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DBHelper.class) {
                if (instance == null) {
                    instance = new DBHelper();
                }
            }
        }
        return instance;
    }

    public DBHelper() throws SQLException {
        String createTasksTable = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "description TEXT NOT NULL," +
                "dueDate DATE NOT NULL," +
                "priority TEXT NOT NULL" +
                ");";

        try(Connection connection = DriverManager.getConnection(url)) {
            Statement statement = connection.createStatement();
            statement.execute(createTasksTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public void addTask(Task task) {
        String sql = "INSERT INTO tasks (title, description, dueDate, priority) VALUES (?, ?, ?, ?)";

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDueDate().toString());
            statement.setString(4, task.getPriority());
            statement.execute();
            int id = statement.getGeneratedKeys().getInt(1);
            task.setId(id);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTask(Task task, int id) {
        String sql = "UPDATE tasks SET title = ?, description = ?, dueDate = ?, priority = ? WHERE id = ?";

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDueDate().toString());
            statement.setString(4, task.getPriority());
            statement.setString(5, String.valueOf(id));
            statement.execute();
            System.out.println("Task with id " + id + " updated successfully");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(id));
            statement.execute();
            System.out.println("Task with id " + id + " deleted successfully");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Task getTask(int taskID) {
        String sql = "SELECT * FROM tasks WHERE id = ?";

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, taskID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                LocalDate dueDate = LocalDate.parse(resultSet.getString("dueDate"));
                String priority = resultSet.getString("priority");

                Task task = new Task(title, description, dueDate, priority);
                task.setId(id);
                return task;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Task> getAllTasks() {
        String sql = "SELECT * FROM tasks";
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                LocalDate dueDate = LocalDate.parse(resultSet.getString("dueDate"));
                String priority = resultSet.getString("priority");


                Task task = new Task(title, description, dueDate, priority);
                task.setId(id);
                tasks.add(task);
                System.out.println(LocalDate.now().plusDays(1));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}

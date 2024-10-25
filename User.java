package com.ToDo;

public class User {
    private String name;
    private TaskList toDoList;

    // Constructor to initialize the user
    public User(String name) {
        this.name = name;
        this.toDoList = new TaskList();
    }

    // To manage tasks
    public void addTask(String description) {
        Task task = new Task(description);
        toDoList.addTask(task);
    }

    public void completeTask(int taskIndex) {
        toDoList.markTaskAsCompleted(taskIndex);
    }

    public void viewTasks() {
        toDoList.printTasks();
    }

    // Getter for the user name
    public String getName() {
        return name;
    }
}

package com.ToDo;

public class Task {
    private String description;
    private boolean isCompleted;

    // Constructor to initialize the task
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Mark the task as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Getters for the task details
    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    //Method to return task info as a string
    @Override
    public String toString() {
        return description + " [" + (isCompleted ? "Completed" : "Pending") + "]";
    }
}


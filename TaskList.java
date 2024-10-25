package com.ToDo;

public class TaskList {
    private TaskNode head;  // Head of the single linked list

    // Inner class representing a node in the linked list
    private class TaskNode {
        Task task;
        TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Method to add a task to the task list
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to mark a task as completed by its index
    public void markTaskAsCompleted(int index) {
        TaskNode current = head;
        int count = 0;

        // Traverse the linked list to find the task by index
        while (current != null) {
            if (count == index) {
                current.task.markAsCompleted();  // Mark the task as completed
                return;
            }
            current = current.next;
            count++;
        }

        // If the index is out of range
        System.out.println("com.ToDo.Task not found at index " + index);
    }

    // Method to print all tasks
    public void printTasks() {
        TaskNode current = head;
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        int count = 0;
        while (current != null) {
            System.out.println(count + ": " + current.task.toString());
            current = current.next;
            count++;
        }
    }
}

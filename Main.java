package com.ToDo;

import java.util.Scanner;

public class Main {
    private static User[] users = new User[10];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu: \n1. Create User\n2. Add Task\n3. Mark Task as Completed\n4. View Tasks\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    User user = selectUser(scanner);  // Ensure 'user' is selected
                    if (user == null) {
                        System.out.println("No valid user selected. Returning to menu.");
                        break;  // If no valid user, break out of this case
                    }

                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();  // Get task description from user input
                    user.addTask(taskDescription);  // Call addTask on the selected user object
                    System.out.println("com.ToDo.Task added successfully.");
                    break;
                case 3:
                    completeTask(scanner);
                    break;
                case 4:
                    viewTasks(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createUser(Scanner scanner) {
        if (userCount >= users.length) {
            System.out.println("com.ToDo.User limit reached.");
            return;
        }

        System.out.println("Enter username: ");
        String name = scanner.nextLine();
        users[userCount] = new User(name);
        userCount++;
        System.out.println("com.ToDo.User created successfully.");
    }

    private static void completeTask(Scanner scanner) {
        User user = selectUser(scanner);
        if (user == null) return;

        user.viewTasks();
        System.out.print("Enter task index to mark as completed: ");
        int taskIndex = scanner.nextInt();
        user.completeTask(taskIndex);
        System.out.println("com.ToDo.Task marked as completed.");
    }

    private static void viewTasks(Scanner scanner) {
        User user = selectUser(scanner);
        if (user == null) return;

        user.viewTasks();
    }

    private static User selectUser(Scanner scanner) {
        if (userCount == 0) {
            System.out.println("No users available.");
            return null;  // No users to select
        }

        System.out.println("Select com.ToDo.User:");
        for (int i = 0; i < userCount; i++) {
            System.out.println(i + ": " + users[i].getName());
        }

        int userIndex = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Check for valid index
        if (userIndex < 0 || userIndex >= userCount) {
            System.out.println("Invalid user selection. Please try again.");
            return null;  // Return null if selection is invalid
        }

        return users[userIndex];  // Return the selected user
    }
}
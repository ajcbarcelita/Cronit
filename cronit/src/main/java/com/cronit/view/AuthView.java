package com.cronit.view;

import com.cronit.util.*;
import com.cronit.controller.UserController;
import com.cronit.model.User;
import java.util.Scanner;

public class AuthView {
    private final Scanner scanner;
    private final UserController userController;

    public AuthView() {
        this.scanner = new Scanner(System.in);
        this.userController = new UserController();
    }

    public int showAuthMenu() {
        System.out.println(ConsoleColors.CYAN + "\nWelcome to Cronit!" + ConsoleColors.RESET);
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Select an option: ");
        int choice = -1;
        while (true) {
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println(ConsoleColors.RED + "Please enter 1 or 2." + ConsoleColors.RESET);
                    System.out.print("Select an option: ");
                }
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "Invalid input. Please enter a number." + ConsoleColors.RESET);
                System.out.print("Select an option: ");
            }  
        }
        return choice;
    }

    public boolean showLogin() {
        System.out.println(ConsoleColors.YELLOW + "Login selected." + ConsoleColors.RESET);
        
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = userController.loginUser(username, password);
        if (success) {
            System.out.println(ConsoleColors.GREEN + "Login successful!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "Login failed. Invalid username or password." + ConsoleColors.RESET);  
        }
        return success;
    }

    public boolean showRegister() {
        System.out.println(ConsoleColors.YELLOW + "Register selected." + ConsoleColors.RESET);
        String username, email, lname, fname, mname, password, confirmPassword;

        // Username
        while (true) {
            System.out.print("Username: ");
            username = scanner.nextLine();
            if (InputValidator.isValidUsername(username)) break;
            System.out.println(ConsoleColors.RED + "Invalid username. Must be 4-20 characters." + ConsoleColors.RESET);
        }

        // Email
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if (InputValidator.isValidEmail(email)) break;
            System.out.println(ConsoleColors.RED + "Invalid email format." + ConsoleColors.RESET);
        }

        // First Name
        while (true) {
            System.out.print("First Name: ");
            fname = scanner.nextLine();
            if (InputValidator.isValidName(fname)) break;
            System.out.println(ConsoleColors.RED + "First name too long (max 50 chars)." + ConsoleColors.RESET);
        }

        // Last Name
        while (true) {
            System.out.print("Last Name: ");
            lname = scanner.nextLine();
            if (InputValidator.isValidName(lname)) break;
            System.out.println(ConsoleColors.RED + "Last name too long (max 50 chars)." + ConsoleColors.RESET);
        }

        // Middle Name (optional)
        System.out.print("Middle Name (optional): ");
        mname = scanner.nextLine();
        if (!InputValidator.isValidName(mname)) {
            System.out.println(ConsoleColors.RED + "Middle name too long (max 50 chars). Ignoring input." + ConsoleColors.RESET);
            mname = "";
        }

        // Password
        while (true) {
            System.out.print("Password: ");
            password = scanner.nextLine();
            if (InputValidator.isValidPassword(password)) break;
            System.out.println(ConsoleColors.RED +
                "Invalid password. Must be at least 8 characters and include 1 uppercase, 1 lowercase, 1 digit, and 1 special character."
                + ConsoleColors.RESET);
        }

        // Confirm Password
        while (true) {
            System.out.print("Confirm Password: ");
            confirmPassword = scanner.nextLine();
            if (confirmPassword.equals(password)) break;
            System.out.println(ConsoleColors.RED + "Passwords do not match. Please try again." + ConsoleColors.RESET);
        }

        System.out.println("Registering user...");
        User newUser = new User(username, email, lname, fname, mname, PasswordUtil.hashPassword(password));
        boolean success = userController.registerUser(newUser);
        if (success) {
            System.out.println(ConsoleColors.GREEN + "Registration successful!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "Registration failed. Username or email may already be in use." + ConsoleColors.RESET);
        }
        return success;
    }
}

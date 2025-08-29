package com.cronit;

import com.cronit.util.DBConnection;
import com.cronit.view.MainView;
import com.cronit.view.AuthView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Cronit CLI Habit Tracker...");

        // Test the DB connection
        if (DBConnection.testConnection()) {
            System.out.println("Ready to start Cronit!");
        } else {
            System.err.println("Cannot continue. Fix database connection first.");
            System.exit(1);
        }

        AuthView authView = new AuthView();
        boolean loggedIn = false;
        while (!loggedIn) {
            int authChoice = authView.showAuthMenu();
            if (authChoice == 1) {
                loggedIn = authView.showLogin();
                if (!loggedIn) {
                    System.out.println("Login failed. Please try again.");
                }
            } else {
                boolean registered = authView.showRegister();
                if (registered) {
                    System.out.println("Registration successful. Please login to continue.");
                } else {
                    System.out.println("Registration failed. Please try again.");
                }
            }
        }

        MainView view = new MainView();
        int choice;
        do {
            view.showMainMenu();
            choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    view.showSuccess("Manage Account selected.");
                    break;
                case 2:
                    view.showSuccess("Manage Habits selected.");
                    break;
                case 3:
                    view.showSuccess("Manage Tags selected.");
                    break;
                case 4:
                    view.showSuccess("Exiting Cronit. Goodbye!");
                    break;
            }
        } while (choice != 4);

        DBConnection.closePool();
    }
}
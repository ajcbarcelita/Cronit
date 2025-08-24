package com.cronit;

import com.cronit.util.DBConnection;

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

        // Later: initialize controllers, menus, etc.
        System.out.println("Cronit setup complete. Implement CLI menus next.");

        // Optional: close HikariCP pool on exit
        DBConnection.closePool();
    }
}

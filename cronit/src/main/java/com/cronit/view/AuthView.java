package com.cronit.view;

import com.cronit.util.ConsoleColors;
import java.util.Scanner;

public class AuthView {
    private final Scanner scanner;

    public AuthView() {
        this.scanner = new Scanner(System.in);
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
        // TODO: Implement login logic
        // Return true if login is successful, false otherwise
        return false;
    }

    public boolean showRegister() {
        System.out.println(ConsoleColors.YELLOW + "Register selected." + ConsoleColors.RESET);
        // TODO: Implement registration logic
        // Return true if registration is successful, false otherwise
        return false;
    }
}

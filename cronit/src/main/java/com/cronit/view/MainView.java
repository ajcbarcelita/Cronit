package com.cronit.view;

import com.cronit.util.ConsoleColors;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner;

    public MainView() {
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        System.out.println(ConsoleColors.CYAN +
                " ██████╗██████╗  ██████╗ ███╗   ██╗██╗████████╗██╗\n" +
                "██╔════╝██╔══██╗██╔═══██╗████╗  ██║██║╚══██╔══╝██║\n" +
                "██║     ██████╔╝██║   ██║██╔██╗ ██║██║   ██║   ██║\n" +
                "██║     ██╔══██╗██║   ██║██║╚██╗██║██║   ██║   ╚═╝\n" +
                "╚██████╗██║  ██║╚██████╔╝██║ ╚████║██║   ██║   ██╗\n" +
                " ╚═════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝   ╚═╝   ╚═╝\n" +
                ConsoleColors.RESET);

        System.out.println("Main Menu:");
        System.out.println("1. Manage Account");
        System.out.println("2. Manage Habits");
        System.out.println("3. Manage Tags");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    public int getUserChoice() {
        int choice = -1;
        while (true) {
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    showError("Please enter a number between 1 and 4.");
                    System.out.print("Select an option: ");
                }
            } catch (NumberFormatException e) {
                showError("Invalid input. Please enter a number.");
                System.out.print("Select an option: ");
            }
        }
        return choice;
    }

    public void showError(String message) {
        System.out.println(ConsoleColors.RED + "Error: " + message + ConsoleColors.RESET);
    }

    public void showSuccess(String message) {
        System.out.println(ConsoleColors.GREEN + "Success: " + message + ConsoleColors.RESET);
    }
}

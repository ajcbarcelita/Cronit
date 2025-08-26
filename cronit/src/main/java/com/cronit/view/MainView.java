package com.cronit.view;

import com.cronit.util.ConsoleColors;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner;

    public MainView() {
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {

    }

    // public int getUserChoice() {}

    public void showError(String message) {
        System.out.println(ConsoleColors.RED + "Error: " + message + ConsoleColors.RESET);
    }

    public void showSuccess(String message) {
        System.out.println(ConsoleColors.GREEN + "Success: " + message + ConsoleColors.RESET);
    }
}

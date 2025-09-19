package controllers;

import java.util.Scanner;
import controllers.AccountController;
import helpers.InputHelper;

import static helpers.InputHelper;


public class MenuController {
    private final Scanner scanner = new Scanner(System.in);
    private final AccountController accountController = new AccountController();


    public void run() {
        boolean running = true;

        System.out.println("Welcome to Your Favourite Bank System");

        while (running) {
            displayMainMenu();
            int choice = InputHelper.getUserChoice("Enter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    handelCreate();
                    break;
                case 2:
                    handelDeposit();
                    break;
                case 3:
                    handelWithdraw();
                    break;
                case 4:
                    handelTransfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("\n===== Main Menu =====");
        System.out.println("\n1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
    }

    private void handelCreate() {
        System.out.println("Create new account selected");
        accountController.createAccount();
    }

    private void handelDeposit() {
        System.out.println("Deposit selected");
    }

    private void handelWithdraw() {
        System.out.println("Withdraw selected");
    }

    private void handelTransfer() {
        System.out.println("Transfer selected");
    }

}

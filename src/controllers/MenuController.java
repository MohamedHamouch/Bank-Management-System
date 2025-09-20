package controllers;

import helpers.InputHelper;

public class MenuController {
    private final AccountController accountController = new AccountController();


    public void run() {
        boolean running = true;

        System.out.println("Welcome to Your Favourite Bank System");

        while (running) {
            displayMainMenu();
            int choice = InputHelper.getUserChoice("Enter your choice: ", 1, 6);

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
                    handelBalanceCheck();
                    break;
                case 6:
                    handelOperationHistory();
                    break;
                case 7:
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n===== Main Menu =====");
        System.out.println("\n1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Check Account Balance");
        System.out.println("6. View Operation History");
        System.out.println("7. Exit");
    }

    private void handelCreate() {
        System.out.println("Create new account selected");
        String msg = accountController.createAccount();
        System.out.println(msg);
    }

    private void handelDeposit() {
        System.out.println("Deposit selected");
        String msg = accountController.deposit();
        System.out.println(msg);
    }

    private void handelWithdraw() {
        System.out.println("Withdraw selected");
        String msg = accountController.withdraw();
        System.out.println(msg);
    }

    private void handelTransfer() {
        System.out.println("Transfer selected");
        String msg = accountController.transfer();
        System.out.println(msg);
    }

    private void handelBalanceCheck() {
        System.out.println("Balance check selected");
        String msg = accountController.balance();
        System.out.println(msg);
    }

    private void handelOperationHistory() {
        System.out.println("Operation history selected");
        accountController.operationHistory();
    }

}

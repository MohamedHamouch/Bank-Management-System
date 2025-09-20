package controllers;

import helpers.InputHelper;

public class MenuController {
    private final AccountController accountController = new AccountController();


    public void run() {
        boolean running = true;

        System.out.println("Welcome to Your Favourite Bank System");

        while (running) {
            displayMainMenu();
            int choice = InputHelper.getUserChoice("Enter your choice: ", 1, 8);

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
                    handelDetails();
                    break;
                case 8:
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
        System.out.println("7. View Account Details");
        System.out.println("8. Exit");
    }

    private void handelCreate() {
        System.out.println("\n=================");
        System.out.println("Create new account selected");
        System.out.println("=================");
        String msg = accountController.createAccount();
        System.out.println(msg);
    }

    private void handelDeposit() {
        System.out.println("Deposit selected");
        System.out.println("=================");
        String msg = accountController.deposit();
        System.out.println(msg);
    }

    private void handelWithdraw() {
        System.out.println("Withdraw selected");
        System.out.println("=================");
        String msg = accountController.withdraw();
        System.out.println(msg);
    }

    private void handelTransfer() {
        System.out.println("Transfer selected");
        System.out.println("=================");
        String msg = accountController.transfer();
        System.out.println(msg);
    }

    private void handelBalanceCheck() {
        System.out.println("Balance check selected");
        System.out.println("=================");
        String msg = accountController.balance();
        System.out.println(msg);
    }

    private void handelOperationHistory() {
        System.out.println("Operation history selected");
        System.out.println("=================");
        accountController.operationHistory();
    }
    private void handelDetails() {
        System.out.println("Account details selected");
        System.out.println("=================");
        accountController.accountDetails();
    }

}

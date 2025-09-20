package controllers;

import models.Account;
import models.Operation;
import services.AccountService;
import helpers.InputHelper;

public class AccountController {
    private final AccountService accountService = new AccountService();

    public String createAccount() {
        while (true) {
            double initialBalance = InputHelper.getDouble("Enter initial balance: ");
            int type = InputHelper.getUserChoice("Choose account type (1. Current, 2. Saving): ", 1, 2);
            try {
                if (type == 1) {
                    double overdraft = InputHelper.getDouble("Enter overdraft limit: ");
                    Account acc = accountService.createCurrentAccount(initialBalance, overdraft);
                    return "Current account created. Number: " + acc.getAccountNumber();
                } else {
                    double interestRate = InputHelper.getDouble("Enter interest rate (in %): ");
                    Account acc = accountService.createSavingAccount(initialBalance, interestRate);
                    return "Saving account created. Number: " + acc.getAccountNumber();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Try again.\n");
            }
        }
    }

    public String deposit() {
        String accNum = InputHelper.getAccountNumber("Account number: ");
        double amount = InputHelper.getDouble("Amount to deposit: ");

        System.out.println("Source options:");
        System.out.println("1. Cash");
        System.out.println("2. Salary");
        System.out.println("3. Transfer");

        int choice = InputHelper.getUserChoice("Choose source (1-3): ", 1, 3);

        String source;
        switch (choice) {
            case 1:
                source = "Cash";
                break;
            case 2:
                source = "Salary";
                break;
            case 3:
                source = "Transfer";
                break;
            default:
                source = "Unknown";
        }

        return accountService.deposit(accNum, amount, source);
    }

    public String withdraw() {
        String accNum = InputHelper.getAccountNumber("Account number: ");
        double amount = InputHelper.getDouble("Amount to withdraw: ");

        System.out.println("Destination options:");
        System.out.println("1. ATM");
        System.out.println("2. Payment");
        System.out.println("3. Transfer");

        int choice = InputHelper.getUserChoice("Choose destination (1-3): ", 1, 3);

        String destination;
        switch (choice) {
            case 1:
                destination = "ATM";
                break;
            case 2:
                destination = "Payment";
                break;
            case 3:
                destination = "Transfer";
                break;
            default:
                destination = "Unknown";
        }

        return accountService.withdraw(accNum, amount, destination);
    }

    public String transfer() {
        String fromAcc = InputHelper.getAccountNumber("Source account number : ");
        String toAcc = InputHelper.getAccountNumber("Destination account number : ");
        double amount = InputHelper.getDouble("Amount to transfer: ");
        return accountService.transfer(fromAcc, toAcc, amount);
    }

    public void operationHistory() {
        String accNum = InputHelper.getAccountNumber("Account number: ");
        Account acc = accountService.getAccount(accNum);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        if (acc.getOperations().isEmpty()) {
            System.out.println("No operations.");
            return;
        }
        System.out.println("Operation history for " + accNum + ":");
        for (Operation op : acc.getOperations()) {
            System.out.println(op);
        }
    }
    public void accountDetails() {
        String accNum = InputHelper.getAccountNumber("Account number: ");
        Account acc = accountService.getAccount(accNum);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        acc.displayDetails();
    }

    public String balance() {
        String accNum = InputHelper.getAccountNumber("Account number: ");
        Account acc = accountService.getAccount(accNum);
        if (acc == null) {
            return "Account not found";
        }
        return "Balance = " + acc.getBalance();
    }
}

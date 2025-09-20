package controllers;

import java.util.Scanner;

import models.Account;
import services.AccountService;
import helpers.InputHelper;

public class AccountController {
    //private final Scanner scanner = new Scanner(System.in);
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
}

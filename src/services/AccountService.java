package services;

import models.Account;
import models.CurrentAccount;
import models.SavingAccount;
import java.util.LinkedHashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, Account> accounts = new LinkedHashMap<>();

    private int counter = 0;

    public String nextAccountNumber() {
        counter++;
        return String.format("CPT-%05d", counter);
    }

    public Account createCurrentAccount(double initialBalance, double overdraft) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be >= 0");
        }
        if (overdraft < 0) {
            throw new IllegalArgumentException("Overdraft must be >= 0");
        }
        String accountNumber = nextAccountNumber();
        Account account = new CurrentAccount(accountNumber, initialBalance, overdraft);
        accounts.put(accountNumber, account);
        return account;
    }

    public Account createSavingAccount(double initialBalance, double interestRate) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be >= 0");
        }
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate must be >= 0");
        }
        String accountNumber = nextAccountNumber();
        Account account = new SavingAccount(accountNumber, initialBalance, interestRate);
        accounts.put(accountNumber, account);
        return account;
    }

    public String deposit(String accountNumber, double amount, String source) {
        if (amount <= 0) {
            return "Deposit failed: amount must be > 0";
        }
        Account acc = accounts.get(accountNumber);
        if (acc == null) {
            return "Deposit failed: account not found";
        }

        double before = acc.getBalance();
        acc.deposit(amount, source);
        double after = acc.getBalance();
        return "Successful deposit. Balance before: " + before + ", after: " + after;
    }

    public String withdraw(String accNum, double amount, String destination) {
        if (amount <= 0) {
            return "Amount must be > 0";
        }
        Account acc = accounts.get(accNum);
        if (acc == null) {
            return "Account not found";
        }
        if( acc.getBalance() <= 0) {
            return "Insufficient funds, balance is below or equal to 0";
        }
        boolean accepted = acc.withdraw(amount, destination);
        if (!accepted) {
            return "Withdrawal denied, not enough funds.";
        }
        return "Successful Withdrawal. New balance = " + acc.getBalance();
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Map<String, Account> getAllAccounts() {
        return accounts;
    }
}

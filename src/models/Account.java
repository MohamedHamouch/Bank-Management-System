package models;

import java.util.*;

abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected List<Operation> operationsList = new ArrayList<>();

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account() {
        this.accountNumber = "0000";
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Operation> getOperationsList() {
        return operationsList;
    }

    public void setOperationsList(List<Operation> operationsList) {
        this.operationsList = operationsList;
    }

    public void addOperation(Operation operation) {
        operationsList.add(operation);
    }

    public abstract String withdraw(double amount);

    public abstract String deposit(double amount, Deposit.Source source);

    public abstract double calculateInterest();

    public abstract void displayDetails();
}
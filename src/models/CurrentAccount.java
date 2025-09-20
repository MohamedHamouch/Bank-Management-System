package models;

public class CurrentAccount extends Account {
    private double overdraft;

    public CurrentAccount() {
        super();
        this.overdraft = 0;
    }

    public CurrentAccount(String accountNumber, double balance, double overdraft) {
        super(accountNumber, balance);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public boolean withdraw(double amount, String destination) {
        double newBalance = this.balance - amount;
        if (newBalance < -this.overdraft) {
            return false;
        }
        this.balance = newBalance;
        addOperation(new Withdrawal(amount, destination));
        return true;
    }

    @Override
    public void deposit(double amount, String source) {
        this.balance += amount;
        Deposit deposit = new Deposit(amount, source);
        addOperation(deposit);
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    @Override
    public void displayDetails() {
        System.out.println("Current Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Overdraft Limit: $" + overdraft);
        System.out.println("Number of Operations: " + operationsList.size());
    }
}
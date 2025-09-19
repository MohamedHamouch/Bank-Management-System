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
    public String withdraw(double amount) {
        double newBalance = this.balance - amount;

        if (newBalance < -this.overdraft) {
            return "Withdrawal denied: insufficient funds!";
        } else {
            this.balance = newBalance;
            Withdrawal withdrawal = new Withdrawal(amount, Withdrawal.Destination.ATM_MACHINE);
            addOperation(withdrawal);
            return "Withdrawal successful: new balance = " + this.balance;
        }
    }

    @Override
    public String deposit(double amount, Deposit.Source source) {
        this.balance += amount;
        Deposit deposit = new Deposit(amount, source);
        addOperation(deposit);
        return "Deposit successful: new balance = " + this.balance;
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
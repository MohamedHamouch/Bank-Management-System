package models;

public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount() {
        super();
        this.interestRate = 0;
    }

    public SavingAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String withdraw(double amount) {
        if (amount > this.balance) {
            return "Withdrawal denied: insufficient funds!";
        } else {
            this.balance -= amount;
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
        return (this.balance * this.interestRate) / 100;
    }

    public void applyInterest() {
        double interest = calculateInterest();
        this.balance += interest;
        Deposit interestDeposit = new Deposit(interest, Deposit.Source.EXTERNAL_TRANSFER);
        addOperation(interestDeposit);
    }

    @Override
    public void displayDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Annual Interest: $" + calculateInterest());
        System.out.println("Number of Operations: " + operationsList.size());
    }
}
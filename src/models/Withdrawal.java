package models;

public class Withdrawal extends Operation {

    private String destination;

    public Withdrawal() {
        super();
        this.destination = "Unknown";
    }

    public Withdrawal(double amount, String destination) {
        super(amount);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return date + " | WITHDRAWAL | amount=" + String.format("%.2f", amount) + " | destination=" + destination;
    }
}
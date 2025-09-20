package models;

public class Deposit extends Operation {

    private String source;

    public Deposit() {
        super();
        this.source = "Unknown";
    }

    public Deposit(double amount, String source) {
        super(amount);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
package models;

public class Withdrawal extends Operation {

    public enum Destination {
        ATM_MACHINE("ATM Machine"),
        CHECK("Check"),
        OUTGOING_TRANSFER("Outgoing Transfer");

        private final String label;

        Destination(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Destination destination;

    public Withdrawal() {
        super();
    }

    public Withdrawal(double amount, Destination destination) {
        super(amount);
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
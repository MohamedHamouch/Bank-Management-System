package models;

public class Deposit extends Operation {

    public enum Source {
        EXTERNAL_TRANSFER("External Transfer"),
        CASH_DEPOSIT("Cash Deposit"),
        SALARY("Salary");

        private final String label;

        Source(String label) {
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

    private Source source;

    public Deposit() {
        super();
    }

    public Deposit(double amount, Source source) {
        super(amount);
        this.source = source;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
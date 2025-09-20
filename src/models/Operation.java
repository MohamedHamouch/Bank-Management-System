package models;

import java.util.UUID;
import java.time.LocalDate;

public abstract class Operation {
    protected UUID number;
    protected LocalDate date;
    protected double amount;

    public Operation(double amount) {
        this.number = UUID.randomUUID();
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public Operation() {
        this(0);
    }

    public UUID getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
package com.example.vistaappartment;

public class Payment {
    private int paymentId;
    private String date;
    private double amount;
    private String description;

    public Payment(int paymentId, String date, double amount, String description) {
        this.paymentId = paymentId;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
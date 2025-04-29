package com.example;

public class BankAccount {
    private double balance;
    private double investment;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.investment = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    // NEW FEATURE: Investment saving space with 14% anual return.
    public void invest(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Investment must be positive");
        if (amount > this.balance) throw new IllegalArgumentException("Investment cannot be mora than balance");
        this.investment += amount;
        this.balance -= amount;
    }

    public double getInvestment() {
        return this.investment;
    }
}

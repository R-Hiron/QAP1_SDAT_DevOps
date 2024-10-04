package com.keyin;

public class Account {
    private String accountNumber;
    private double balance;
    private Customer owner;

    public Account(String accountNumber, Customer owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0.0;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Customer getOwner() { return owner; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds or invalid amount.");
        }
    }
}
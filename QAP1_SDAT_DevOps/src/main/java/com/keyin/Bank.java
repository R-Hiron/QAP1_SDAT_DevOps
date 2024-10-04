package com.keyin;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Customer> customers = new HashMap<>();
    private Map<String, Account> accounts = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    public void openAccount(String accountNumber, String customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            Account account = new Account(accountNumber, customer);
            accounts.put(accountNumber, account);
        } else {
            throw new IllegalArgumentException("Customer does not exist.");
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void closeAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            System.out.println("Account closed successfully.");
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            System.out.println("Accounts:");
            for (Account account : accounts.values()) {
                System.out.println("- Account Number: " + account.getAccountNumber() +
                        ", Owner: " + account.getOwner().getName() +
                        ", Balance: $" + account.getBalance());
            }
        }
    }

    public boolean customerExists(String customerId) {
        return customers.containsKey(customerId);
    }

}

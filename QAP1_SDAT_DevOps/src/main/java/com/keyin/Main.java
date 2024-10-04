package com.keyin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Bank Account Management System!");

        while (!exit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add Customer");
            System.out.println("2. Open Account");
            System.out.println("3. Close Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Check Balance");
            System.out.println("7. List Accounts");
            System.out.println("8. Exit");

            System.out.print("Enter your choice (1-8): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addCustomer(bank, scanner);
                    break;
                case "2":
                    openAccount(bank, scanner);
                    break;
                case "3":
                    closeAccount(bank, scanner);
                    break;
                case "4":
                    depositMoney(bank, scanner);
                    break;
                case "5":
                    withdrawMoney(bank, scanner);
                    break;
                case "6":
                    checkBalance(bank, scanner);
                    break;
                case "7":
                    bank.listAccounts();
                    break;
                case "8":
                    exit = true;
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }

        scanner.close();
    }
    private static void addCustomer(Bank bank, Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        if (bank.customerExists(customerId)) {
            System.out.println("Customer ID already exists.");
        } else {
            Customer customer = new Customer(customerId, name, email);
            bank.addCustomer(customer);
            System.out.println("Customer added successfully.");
        }
    }

    private static void openAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        bank.openAccount(accountNumber, customerId);
    }

    private static void closeAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter Account Number to close: ");
        String accountNumber = scanner.nextLine();

        bank.closeAccount(accountNumber);
    }

    private static void depositMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                account.deposit(amount);
                System.out.println("Deposited $" + amount + " successfully.");
                System.out.println("Current Balance: $" + account.getBalance());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    private static void withdrawMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                account.withdraw(amount);
                System.out.println("Withdrew $" + amount + " successfully.");
                System.out.println("Current Balance: $" + account.getBalance());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    private static void checkBalance(Bank bank, Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            System.out.println("Current Balance: $" + account.getBalance());
        } else {
            System.out.println("Account does not exist.");
        }
    }

}

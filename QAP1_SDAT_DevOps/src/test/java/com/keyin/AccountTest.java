package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testDeposit() {
        Customer customer = new Customer("CUST1001", "John Doe", "john.doe@example.com");
        Account account = new Account("ACC1001", customer);

        account.deposit(100.0);
        Assertions.assertEquals(100.0, account.getBalance());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
        assertEquals("Amount must be positive.", exception.getMessage());
    }

    @Test
    public void testWithdraw() {
        Customer customer = new Customer("CUST1001", "John Doe", "john.doe@example.com");
        Account account = new Account("ACC1001", customer);
        account.deposit(200.0);

        account.withdraw(100.0);
        Assertions.assertEquals(100.0, account.getBalance());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });
        assertEquals("Insufficient funds or invalid amount.", exception.getMessage());
    }
}

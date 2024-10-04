package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testAddCustomerAndOpenAccount() {
        Bank bank = new Bank();
        Customer customer = new Customer("CUST1001", "Jane Smith", "jane.smith@example.com");
        bank.addCustomer(customer);

        bank.openAccount("ACC1002", "CUST1001");
        Account account = bank.getAccount("ACC1002");
        assertNotNull(account);
        Assertions.assertEquals("ACC1002", account.getAccountNumber());
        Assertions.assertEquals(customer, account.getOwner());
    }

    @Test
    public void testOpenAccountWithInvalidCustomer() {
        Bank bank = new Bank();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.openAccount("ACC1003", "CUST9999");
        });
        assertEquals("Customer does not exist.", exception.getMessage());
    }

    @Test
    public void testCloseAccount() {
        Bank bank = new Bank();
        Customer customer = new Customer("CUST1004", "Eve", "eve@example.com");
        bank.addCustomer(customer);

        bank.openAccount("ACC1004", "CUST1004");
        assertNotNull(bank.getAccount("ACC1004"));

        bank.closeAccount("ACC1004");
        assertNull(bank.getAccount("ACC1004"));
    }

    @Test
    public void testListAccounts() {
        Bank bank = new Bank();
        bank.listAccounts();

        Customer customer = new Customer("CUST1005", "Frank", "frank@example.com");
        bank.addCustomer(customer);
        bank.openAccount("ACC1005", "CUST1005");

        bank.listAccounts();
    }
}

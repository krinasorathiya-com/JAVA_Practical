package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import model.Account;

public class BankServiceTest {

    @Test
    void saveAndReloadKeepsDataUnchanged()
            throws Exception {

        BankService bank = new BankService();

        bank.addAccount(
            new Account(101, "Krina", 5000)
        );

        bank.addAccount(
            new Account(102, "Riya", 7000)
        );

        String fileName = "accounts.dat";

        bank.saveData(fileName);

        BankService newBank =
            new BankService();

        newBank.loadData(fileName);

        assertEquals(
            bank.getAccountCount(),
            newBank.getAccountCount()
        );

        Account account =
            newBank.getAccount(101);

        assertNotNull(account);

        assertEquals(
            "Krina",
            account.getName()
        );

        assertEquals(
            5000,
            account.getBalance()
        );

        Account account2 =
            newBank.getAccount(102);

        assertNotNull(account2);

        assertEquals(
            "Riya",
            account2.getName()
        );

        assertEquals(
            7000,
            account2.getBalance()
        );
    }
}
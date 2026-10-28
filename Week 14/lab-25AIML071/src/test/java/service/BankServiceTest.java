package service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import model.Account;

public class BankServiceTest {

    @Test
    void addingAccountIncreasesCount() {

        BankService bank = new BankService();

        assertEquals(0, bank.getAccountCount());

        bank.addAccount(
            new Account(101, "Krina", 5000)
        );

        assertEquals(1, bank.getAccountCount());
    }

    @Test
    void addingSecondAccountIncreasesCount() {

        BankService bank = new BankService();

        bank.addAccount(
            new Account(101, "Krina", 5000)
        );

        bank.addAccount(
            new Account(102, "Riya", 7000)
        );

        assertEquals(2, bank.getAccountCount());
    }

    @Test
    void invalidActionThrowsException() {

        BankService bank = new BankService();

        assertEquals(
            IllegalArgumentException.class,
            assertThrows(
                IllegalArgumentException.class,
                () -> bank.performAction(99)
            ).getClass()
        );
    }
}
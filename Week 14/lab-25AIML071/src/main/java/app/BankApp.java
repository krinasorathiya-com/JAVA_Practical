package app;

import model.Account;
import service.BankService;

public class BankApp {

    public static void main(String[] args) {

        BankService bank = new BankService();

        bank.addAccount(
            new Account(101, "Krina", 5000)
        );

        bank.addAccount(
            new Account(102, "Riya", 7000)
        );

        System.out.println("Mini Bank Application");
        System.out.println("----------------------");

        System.out.println(
            "Total Accounts: " +
            bank.getAccountCount()
        );

        Account account = bank.getAccount(101);

        if (account != null) {

            System.out.println(
                "Account No: " +
                account.getAccountNo()
            );

            System.out.println(
                "Name: " +
                account.getName()
            );

            System.out.println(
                "Balance: " +
                account.getBalance()
            );
        }
    }
}
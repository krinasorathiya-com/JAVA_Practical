package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Account;

public class BankService {

    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public int getAccountCount() {
        return accounts.size();
    }

    public Account getAccount(int accountNo) {

        for (Account account : accounts) {

            if (account.getAccountNo() == accountNo) {
                return account;
            }
        }

        return null;
    }

    // Save data into file
    public void saveData(String fileName) throws IOException {

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName)
        )) {
            out.writeObject(accounts);
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    public void loadData(String fileName)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName)
        )) {
            accounts =
                    (ArrayList<Account>) in.readObject();
        }
    }

    public Object performAction(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performAction'");
    }
}
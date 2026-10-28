import java.util.ArrayList;

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

    public void performAction(int action) {

        if (action < 1 || action > 3) {
            throw new IllegalArgumentException(
                "Invalid action"
            );
        }

        System.out.println("Valid action: " + action);
    }
}
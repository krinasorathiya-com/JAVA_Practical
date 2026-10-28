public class BankServiceTest {

    public static void main(String[] args) {
        addingAccountIncreasesCount();
        addingSecondAccountIncreasesCount();
        invalidActionThrowsException();
    }

    static void addingAccountIncreasesCount() {

        BankService bank = new BankService();

        check(bank.getAccountCount() == 0, "Expected no accounts initially");

        bank.addAccount(
            new Account(101, "Krina", 5000)
        );

        check(bank.getAccountCount() == 1, "Expected one account after adding an account");
    }

    static void addingSecondAccountIncreasesCount() {

        BankService bank = new BankService();

        bank.addAccount(
            new Account(101, "Krina", 5000)
        );

        bank.addAccount(
            new Account(102, "Riya", 7000)
        );

        check(bank.getAccountCount() == 2, "Expected two accounts after adding two accounts");
    }

    static void invalidActionThrowsException() {

        BankService bank = new BankService();

        try {
            bank.performAction(99);
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("Expected IllegalArgumentException for invalid action");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
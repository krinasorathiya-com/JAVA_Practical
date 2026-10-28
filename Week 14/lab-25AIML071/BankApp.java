import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            BankService bank = new BankService();
            
            OUTER:
            while (true) {
                System.out.println("\n--- Mini Bank ---");
                System.out.println("1. Add Account");
                System.out.println("2. Show Account Count");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter account number: ");
                        int number = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter balance: ");
                        double balance = sc.nextDouble();
                        Account account =
                                new Account(number, name, balance);
                        bank.addAccount(account);
                        System.out.println(
                                "Account added successfully."
                        );
                    }
                    case 2 -> System.out.println(
                            "Total accounts: " +
                                    bank.getAccountCount()
                    );
                    case 3 -> {
                        System.out.println("Thank you!");
                        break OUTER;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
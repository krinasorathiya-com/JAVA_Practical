import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankService bank = new BankService();

        while (true) {

            System.out.println("\n--- Mini Bank ---");
            System.out.println("1. Add Account");
            System.out.println("2. Show Account Count");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

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

            } else if (choice == 2) {

                System.out.println(
                    "Total accounts: " +
                    bank.getAccountCount()
                );

            } else if (choice == 3) {

                System.out.println("Thank you!");
                break;

            } else {

                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
import java.util.Scanner;

@FunctionalInterface
interface DiscountRule {
    double apply(double price);
}

public class part2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] prices = {1000, 2000, 3000, 4000};

        System.out.println("Choose Discount Rule:");
        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. Flat Rs. 100 Discount");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        DiscountRule rule;

        switch (choice) {
            case 1 -> rule = price -> price * 0.90;
            case 2 -> rule = price -> price * 0.80;
            case 3 -> rule = price -> Math.max(0, price - 100);
            default -> {
                System.out.println("Invalid choice.");
                sc.close();
                return;
            }
        }

        System.out.println("\nPrices after discount:");

        for (double price : prices) {
            System.out.println("Original Price: Rs. " + price
                    + " -> Final Price: Rs. " + rule.apply(price));
        }

        sc.close();
    }
}

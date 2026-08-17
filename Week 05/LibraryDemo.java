
public class LibraryDemo {
    public static void main(String[] args) {

        Media[] returned = {
                new Book("Java Basics", 4),
                new DVD("Interstellar", 3),
                new Magazine("Science Today", 6),
                new Book("OOP Concepts", 2)
        };

        double totalFee = 0;

        for (Media m : returned) {
            double fee = m.lateFee();

            System.out.println(m.title + " (" +
                    m.getClass().getSimpleName() + ")");
            System.out.println("Late Fee = ₹" + fee);
            System.out.println();

            totalFee += fee;
        }

        System.out.println("Total Late Fees = ₹" + totalFee);
    }
}
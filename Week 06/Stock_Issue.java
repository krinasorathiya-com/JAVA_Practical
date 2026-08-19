class OutOfStockException extends Exception {
    OutOfStockException(int shortfall) {
        super("Out of stock! Shortfall = " + shortfall);
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String msg) {
        super(msg);
    }
}

class Warehouse {
    int stock = 10;

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0)
            throw new InvalidQuantityException("Invalid quantity!");

        if (qty > stock)
            throw new OutOfStockException(qty - stock);

        stock = stock - qty;
        System.out.println(qty + " " + item + " issued.");
    }
}

public class Stock_Issue {
    public static void main(String[] args) {

        Warehouse w = new Warehouse();

        String[] items = {"Pen", "Book", "Bag", "Pencil"};
        int[] qty = {3, 15, 0, 2};

        for (int i = 0; i < items.length; i++) {

            try {
                w.issue(items[i], qty[i]);
            }
            catch (OutOfStockException | InvalidQuantityException e) {
                System.out.println(items[i] + ": " + e.getMessage());
            }
        }

        System.out.println("All requests processed.");
    }
}

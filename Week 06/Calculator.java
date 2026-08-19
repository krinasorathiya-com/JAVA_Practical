import java.util.Scanner;

class DivideByZeroException extends Exception {
    DivideByZeroException(String msg) {
        super(msg);
    }
}

class InvalidNumberException extends Exception {
    InvalidNumberException(String msg) {
        super(msg);
    }
}

public class Calculator {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            boolean success = false;

            while (!success) {
                try {
                    System.out.print("Enter expression (a operator b): ");

                    String a = sc.next();
                    char op = sc.next().charAt(0);
                    String b = sc.next();

                    if (!a.matches("\\d+") || !b.matches("\\d+"))
                        throw new InvalidNumberException("Invalid number!");

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    if (op == '/' && y == 0)
                        throw new DivideByZeroException("Cannot divide by zero!");

                    switch (op) {
                        case '+' -> System.out.println("Result = " + (x + y));
                        case '-' -> System.out.println("Result = " + (x - y));
                        case '*' -> System.out.println("Result = " + (x * y));
                        case '/' -> System.out.println("Result = " + (x / y));
                        default -> System.out.println("Invalid operator!");
                    }

                    success = true;
                }

                catch (InvalidNumberException | DivideByZeroException e) {
                    System.out.println(e.getMessage());
                }

                finally {
                    System.out.println("Attempt logged.");
                }
            }
        }
    }
} 
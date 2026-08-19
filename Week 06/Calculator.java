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

        Scanner sc = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            try {
                System.out.print("Enter Operand and Operator: ");

                int a = sc.nextInt();
                char op = sc.next().charAt(0);
                int b = sc.nextInt();

                if (a < 0 || b < 0)
                    throw new InvalidNumberException("Negative number is not allowed!");

                if (op == '*' && (a == 0 || b == 0))
                    throw new InvalidNumberException("0 is not allowed in multiplication!");

                if (op == '/' && b == 0)
                    throw new DivideByZeroException("Cannot divide by zero!");

                switch (op) {
                    case '+':
                        System.out.println("Result = " + (a + b));
                        break;
                    case '-':
                        System.out.println("Result = " + (a - b));
                        break;
                    case '*':
                        System.out.println("Result = " + (a * b));
                        break;
                    case '/':
                        System.out.println("Result = " + (a / b));
                        break;
                    default:
                        System.out.println("Invalid operator!");
                        break;
                }

                done = true;
            }

            catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

            catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

            catch (Exception e) {
                System.out.println("Please enter valid numbers!");
                sc.nextLine();
            }

            finally {
                System.out.println("Attempt logged.\n");
            }
        }

        sc.close();
    }
}
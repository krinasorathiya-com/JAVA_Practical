class MyStack<T> {

    private final T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    MyStack(int size) {
        stack = (T[]) new Object[size];
        top = -1;
    }

    void push(T value) {

        if (top == stack.length - 1) {
            System.out.println("Stack is full.");
            return;
        }

        stack[++top] = value;
    }

    T pop() {

        if (top == -1) {
            return null;
        }

        return stack[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class GenericStack {

    public static void main(String[] args) {

        MyStack<Integer> numbers = new MyStack<>(5);

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        System.out.println("Integer Stack:");

        while (!numbers.isEmpty()) {
            System.out.println(numbers.pop());
        }

        MyStack<String> names = new MyStack<>(5);

        names.push("Krina");
        names.push("Riya");
        names.push("Neha");

        System.out.println("\nString Stack:");

        while (!names.isEmpty()) {
            System.out.println(names.pop());
        }

        System.out.println("\nPop from empty stack: "
                        + names.pop());
    }
}
class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

class Pair<A, B> {
    private final A first;
    private final B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    A getFirst() {
        return first;
    }

    B getSecond() {
        return second;
    }
}

public class GenericContainers {

    public static <T> T firstElement(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>();
        intBox.set(100);

        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Java");

        System.out.println("Integer Box: " + intBox.get());
        System.out.println("String Box: " + stringBox.get());

        Pair<String, Integer> student =
            new Pair<>("Krina", 101);

        System.out.println("Name: " + student.getFirst());
        System.out.println("Roll No: " + student.getSecond());

        Integer[] numbers = {10, 20, 30};
        String[] names = {"Java", "Python", "C++"};

        System.out.println(
            "First Number: " + firstElement(numbers)
        );

        System.out.println(
            "First Name: " + firstElement(names)
        );
    }
}
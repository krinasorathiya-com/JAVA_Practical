class SharedTotal {
    static long total = 0;

    static void add(int value) {
        total += value;
    }

    synchronized static void synchronizedAdd(int value) {
        total += value;
    }
}

public class ArraySumThreads {

    static final int SIZE = 100000;
    static final int THREADS = 4;

    public static void main(String[] args) throws InterruptedException {

        int[] numbers = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            numbers[i] = 1;
        }

        SharedTotal.total = 0;

        Thread[] t1 = new Thread[THREADS];

        int part = SIZE / THREADS;

        for (int i = 0; i < THREADS; i++) {

            final int start = i * part;
            final int end = (i + 1) * part;

            t1[i] = new Thread(() -> {

                for (int j = start; j < end; j++) {
                    SharedTotal.add(numbers[j]);
                }

            });

            t1[i].start();
        }

        for (Thread t : t1) {
            t.join();
        }

        System.out.println("Without synchronization: "
                + SharedTotal.total);


        SharedTotal.total = 0;

        Thread[] t2 = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {

            final int start = i * part;
            final int end = (i + 1) * part;

            t2[i] = new Thread(() -> {

                for (int j = start; j < end; j++) {
                    SharedTotal.synchronizedAdd(numbers[j]);
                }

            });

            t2[i].start();
        }

        for (Thread t : t2) {
            t.join();
        }

        System.out.println("With synchronization: "
                + SharedTotal.total);

        System.out.println("Expected total: " + SIZE);
    }
}

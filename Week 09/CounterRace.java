class Counter {
    int count = 0;

    void increment() {
        count++;
    }

    synchronized void synchronizedIncrement() {
        count++;
    }
}

public class CounterRace {
    static final int THREADS = 10;
    static final int INCREMENTS = 10000;

    public static void main(String[] args) throws InterruptedException {

        // Without synchronization
        Counter c1 = new Counter();
        Thread[] t1 = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            t1[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    c1.increment();
                }
            });
            t1[i].start();
        }

        for (Thread t : t1) {
            t.join();
        }

        System.out.println("Without synchronization: " + c1.count);

        // With synchronization
        Counter c2 = new Counter();
        Thread[] t2 = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            t2[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    c2.synchronizedIncrement();
                }
            });
            t2[i].start();
        }

        for (Thread t : t2) {
            t.join();
        }

        System.out.println("With synchronization: " + c2.count);
        System.out.println("Expected count: " + (THREADS * INCREMENTS));
    }
}
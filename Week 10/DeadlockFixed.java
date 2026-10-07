class Account {
    String name;

    Account(String name) {
        this.name = name;
    }
}

public class DeadlockFixed {

    public static void main(String[] args) {

        Account accountA = new Account("Account A");
        Account accountB = new Account("Account B");

        Thread t1 = new Thread(() -> {

            // Always lock Account A first
            synchronized (accountA) {
                System.out.println("Thread 1 locked Account A");

                synchronized (accountB) {
                    System.out.println("Thread 1 locked Account B");
                    System.out.println("Thread 1 completed transfer");
                }
            }
        });

        Thread t2 = new Thread(() -> {

            // Also lock Account A first
            synchronized (accountA) {
                System.out.println("Thread 2 locked Account A");

                synchronized (accountB) {
                    System.out.println("Thread 2 locked Account B");
                    System.out.println("Thread 2 completed transfer");
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Both transfers completed successfully.");
    }
}


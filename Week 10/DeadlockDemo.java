class Account {
    String name;

    Account(String name) {
        this.name = name;
    }
}

public class DeadlockDemo {

    public static void main(String[] args) {

        Account accountA = new Account("Account A");
        Account accountB = new Account("Account B");

        Thread t1 = new Thread(() -> {

            synchronized (accountA) {
                System.out.println("Thread 1 locked Account A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                synchronized (accountB) {
                    System.out.println("Thread 1 locked Account B");
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (accountB) {
                System.out.println("Thread 2 locked Account B");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                synchronized (accountA) {
                    System.out.println("Thread 2 locked Account A");
                }
            }
        });

        t1.start();
        t2.start();
    }
}



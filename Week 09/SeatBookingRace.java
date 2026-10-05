class SeatBooking {
    int seatsLeft = 5;

    void bookWithoutSync(String name) {
        if (seatsLeft > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            seatsLeft--;
            System.out.println(name + " booked a seat.");
        } else {
            System.out.println(name + " could not book a seat.");
        }
    }

    synchronized void bookWithSync(String name) {
        if (seatsLeft > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            seatsLeft--;
            System.out.println(name + " booked a seat.");
        } else {
            System.out.println(name + " could not book a seat.");
        }
    }
}

public class SeatBookingRace {

    public static void main(String[] args) throws InterruptedException {

        // Without synchronization
        System.out.println("----- WITHOUT SYNCHRONIZATION -----");

        SeatBooking booking1 = new SeatBooking();
        Thread[] threads1 = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int student = i + 1;

            threads1[i] = new Thread(() -> {
                booking1.bookWithoutSync("Student " + student);
            });

            threads1[i].start();
        }

        for (Thread t : threads1) {
            t.join();
        }

        System.out.println("Seats left: " + booking1.seatsLeft);

        // With synchronization
        System.out.println("\n----- WITH SYNCHRONIZATION -----");

        SeatBooking booking2 = new SeatBooking();
        Thread[] threads2 = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int student = i + 1;

            threads2[i] = new Thread(() -> {
                booking2.bookWithSync("Student " + student);
            });

            threads2[i].start();
        }

        for (Thread t : threads2) {
            t.join();
        }

        System.out.println("Seats left: " + booking2.seatsLeft);
    }
}

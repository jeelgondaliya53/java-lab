public class Ticket {
    static int seatsleft = 5;
    static int booked = 0;

    static void book() {
        if (seatsleft > 0) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }

            seatsleft--;
            booked++;

            System.out.println("seats left: " + seatsleft);
        }
    }

    static synchronized void syncBook() {
        if (seatsleft > 0) {
            seatsleft--;
            booked++;

            System.out.println("Seat booked successfully, seats left: " + seatsleft);
        }
    }

    public static void main(String args[]) throws InterruptedException {

        Thread[] t = new Thread[10];

        seatsleft = 5;
        booked = 0;

        System.out.println("Without synchronization:");

        for (int i = 0; i < 10; i++) {
            t[i] = new Thread(() -> book());
            t[i].start();
        }

        for (int i = 0; i < 10; i++)
            t[i].join();

        System.out.println("Total booked: " + booked);
        System.out.println("Seats left: " + seatsleft);

        seatsleft = 5;
        booked = 0;

        System.out.println("\nWith synchronization:");

        for (int i = 0; i < 10; i++) {
            t[i] = new Thread(() -> syncBook());
            t[i].start();
        }

        for (int i = 0; i < 10; i++)
            t[i].join();

        System.out.println("Total booked: " + booked);
        System.out.println("Seats left: " + seatsleft);
    }
}
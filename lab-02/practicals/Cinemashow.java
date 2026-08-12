public class Cinemashow {

    private String title;
    private int seatsAvailable;

    private final int capacity;
    private static int totalBooked = 0;

    public Cinemashow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    public Cinemashow(String title) {
        this(title, 100);
    }

    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    public void cancel(int n) {
        seatsAvailable += n;
        if (seatsAvailable > capacity) {

            seatsAvailable = capacity;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        Cinemashow show = new Cinemashow("Avengers", 50);

        System.out.println(show.book(20));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println(show.book(25));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println(show.book(10));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        show.cancel(15);
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println(show.book(10));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println("Total Booked: " + Cinemashow.getTotalBooked());
    }
}

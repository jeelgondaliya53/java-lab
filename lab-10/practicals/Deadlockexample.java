public class Deadlockexample {
    static Object pen = new Object();
    static Object notebook = new Object();

    public static void main(String[] args) throws InterruptedException {

        // Non-fixed version: Deadlock
        Thread t1 = new Thread(() -> {
            synchronized (pen) {
                System.out.println("T1 locked Pen");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                synchronized (notebook) {
                    System.out.println("T1 locked Notebook");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (notebook) {
                System.out.println("T2 locked Notebook");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                synchronized (pen) {
                    System.out.println("T2 locked Pen");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Fixed version: Consistent lock order
        Thread t3 = new Thread(() -> {
            synchronized (pen) {
                System.out.println("T3 locked Pen");

                synchronized (notebook) {
                    System.out.println("T3 locked Notebook");
                }
            }
            System.out.println("T3 finished");
        });

        Thread t4 = new Thread(() -> {
            synchronized (pen) {
                System.out.println("T4 locked Pen");

                synchronized (notebook) {
                    System.out.println("T4 locked Notebook");
                }
            }
            System.out.println("T4 finished");
        });

        t3.start();
        t4.start();
    }
}
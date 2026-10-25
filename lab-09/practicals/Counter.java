public class Counter {
    static int count = 0;

   
    static synchronized void increment() {
        count++;
    }



    public static void main(String args[]) throws InterruptedException {

        count = 0;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                count++;
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                count++;
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Without synchronization: " + count);

        count = 0;

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                increment();
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                increment();
        });
      
        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("With synchronization: " + count);
    }
}
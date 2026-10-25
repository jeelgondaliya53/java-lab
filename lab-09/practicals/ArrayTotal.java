import java.util.concurrent.atomic.AtomicLong;

public class ArrayTotal {
    static long total = 0;

    static void add(long value) {
        total += value;
    }

    static synchronized void syncAdd(long value) {
        total += value;
    }

    public static void main(String[] args) throws Exception {

        int[] arr = new int[1000000];

        for (int i = 0; i < arr.length; i++)
            arr[i] = 1;

        Thread[] threads = new Thread[4];

        // Without synchronization
        total = 0;
        long start = System.nanoTime();

        for (int i = 0; i < 4; i++) {
            int startIndex = i * 250000;
            int endIndex = startIndex + 250000;

            threads[i] = new Thread(() -> {
                for (int j = startIndex; j < endIndex; j++)
                    add(arr[j]);
            });

            threads[i].start();
        }

        for (Thread t : threads)
            t.join();

        long time1 = System.nanoTime() - start;

        System.out.println("Without synchronization: " + total);
        System.out.println("Time: " + time1 + " ns");

        // With synchronized
        total = 0;
        start = System.nanoTime();

        for (int i = 0; i < 4; i++) {
            int startIndex = i * 250000;
            int endIndex = startIndex + 250000;

            threads[i] = new Thread(() -> {
                for (int j = startIndex; j < endIndex; j++)
                    syncAdd(arr[j]);
            });

            threads[i].start();
        }

        for (Thread t : threads)
            t.join();

        long time2 = System.nanoTime() - start;

        System.out.println("With synchronized: " + total);
        System.out.println("Time: " + time2 + " ns");

        // With AtomicLong
        AtomicLong atomicTotal = new AtomicLong(0);
        start = System.nanoTime();

        for (int i = 0; i < 4; i++) {
            int startIndex = i * 250000;
            int endIndex = startIndex + 250000;

            threads[i] = new Thread(() -> {
                for (int j = startIndex; j < endIndex; j++)
                    atomicTotal.addAndGet(arr[j]);
            });

            threads[i].start();
        }

        for (Thread t : threads)
            t.join();

        long time3 = System.nanoTime() - start;

        System.out.println("With AtomicLong: " + atomicTotal);
        System.out.println("Time: " + time3 + " ns");
    }
}
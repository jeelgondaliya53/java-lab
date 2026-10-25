import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            final int id = i;

            service.execute(() -> {
                System.out.println("Task " + id + " executed by "
                        + Thread.currentThread().getName());
                System.out.println("Task " + id + " finished");
            });
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("All tasks completed.");
    }
}
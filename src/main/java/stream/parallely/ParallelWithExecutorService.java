package stream.parallely;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelWithExecutorService {
    private static final int parallelism = 8;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> ranges = IntStream.range(1, 1_000).boxed().collect(Collectors.toList());
        Set<Long> threads = new HashSet<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int range: ranges) {
            executorService.submit(() -> {
                System.out.printf("%s ", range);
                threads.add(Thread.currentThread().getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(80, TimeUnit.MILLISECONDS)) {
                System.out.println("Force shutdown");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println(executorService.isShutdown());
        System.out.println("Threads size = " + threads.size() + " " + threads);

    }
}

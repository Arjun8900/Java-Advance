package stream.parallely;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {
    private static final int parallelism = 8;

    public static void main(String[] args) {
        parallelStreamWithForkJoin();
        executorService();
    }

    private static void parallelStreamWithForkJoin() {
        ForkJoinPool forkJoinPool = null;
        Set<Long> threads = new HashSet<>();
        List<Integer> ranges = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());
        try {
            forkJoinPool = new ForkJoinPool(parallelism);
            forkJoinPool.submit(() -> ranges.parallelStream().forEach((theInt) -> {
                performOperation(threads, theInt);
            })).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (forkJoinPool != null) {
                forkJoinPool.shutdown();
            }
        }
        System.out.println(threads.size() + " " + threads);
    }

    private static void performOperation(Set<Long> threads, Integer theInt) {
        sleep(100);
        System.out.println(Thread.currentThread().getName() + " -- " + theInt);
        threads.add(Thread.currentThread().getId());
    }

    private static void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch (Exception ignore) {
        }
    }

    private static void executorService() {
        List<Integer> ranges = IntStream.range(1, 1_000).boxed().collect(Collectors.toList());
        Set<Long> threads = new HashSet<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int range: ranges) {
            executorService.submit(() -> {
                submitToExecutorService(threads, range);
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

    private static void submitToExecutorService(Set<Long> threads, int range) {
        System.out.printf("%s ", range);
        threads.add(Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

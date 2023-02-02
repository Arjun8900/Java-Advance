package stream.parallely;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ParallelForkJoin {
    private static final int parallelism = 8;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> ranges = IntStream.range(1, 1_000).boxed().collect(Collectors.toList());
        Set<Long> threads = new HashSet<>();
        ForkJoinPool forkJoinPool = new ForkJoinPool(parallelism);
        Stream<Integer> stream = ranges.parallelStream();
        try {
            forkJoinPool.submit(() ->
                    stream.forEach(table -> {
                        try {

                        } catch (Exception e) {
                            System.out.println("ERROR");
                        }
                    })).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (forkJoinPool != null) {
                forkJoinPool.shutdown();
            }
        }

        System.out.println("Threads size = " + threads.size() + " " + threads);

    }
}

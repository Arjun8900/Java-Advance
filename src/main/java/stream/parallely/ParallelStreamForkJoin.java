package stream.parallely;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamForkJoin {
    private static final int parallelism = 8;

    public static void main(String[] args)  {
        ForkJoinPool forkJoinPool = null;
        Set<Long> threads = new HashSet<>();
        List<Integer> ranges = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());
        try {
            forkJoinPool = new ForkJoinPool(parallelism);
            forkJoinPool.submit(() -> ranges.parallelStream().forEach((theInt) -> {
//                                try { Thread.sleep(100); } catch (Exception ignore) {}
//                                System.out.println(Thread.currentThread().getName() + " -- " + theInt);
                        threads.add(Thread.currentThread().getId());
                    })
            ).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        } finally {
            if (forkJoinPool != null) {
                forkJoinPool.shutdown();
            }
        }
        System.out.println(threads.size() + " " + threads);

    }
}

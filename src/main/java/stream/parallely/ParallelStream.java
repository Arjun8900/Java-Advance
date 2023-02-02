package stream.parallely;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Set<String> threadsParallelStream = new HashSet<>();
        List<Integer> rangesParallelStream = IntStream.range(1, 100_000).boxed().collect(Collectors.toList());

        rangesParallelStream.parallelStream().forEach((theInt) -> {
//                                try { Thread.sleep(100); } catch (Exception ignore) {}
//                                System.out.println(Thread.currentThread().getName() + " -- " + theInt);
            threadsParallelStream.add(Thread.currentThread().getName());
        });

        System.out.println(threadsParallelStream.size() + " " + threadsParallelStream);
    }
}

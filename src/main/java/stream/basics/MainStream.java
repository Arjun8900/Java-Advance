package stream.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {
    public static void main(String[] args) {
        List<Integer> lists = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());

        long start = System.currentTimeMillis();

        lists.stream().parallel().forEach(i -> System.out.println(i + " " + Thread.currentThread().getName()));
        System.out.println("Time taken = " + (System.currentTimeMillis()-start));
    }
}

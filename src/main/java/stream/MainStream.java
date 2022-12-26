package stream;

import java.util.ArrayList;
import java.util.List;

public class MainStream {
    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        for (int i =0; i<1000; i++) {
            lists.add(i);
        }
        long start = System.currentTimeMillis();

//        lists.stream().parallel().forEach(System.out::println);
        lists.stream().parallel().forEach(i -> System.out.println(i + " " + Thread.currentThread().getName()));
//        System.out.println();

//        lists.stream().forEach(i -> System.out.println(i + " " + Thread.currentThread().getName()));
        System.out.println("Time taken = " + (System.currentTimeMillis()-start));


    }
}

package stream.basics;

import java.util.Arrays;
import java.util.List;

public class SkipAndLimit {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().skip(1).limit(70).filter(i -> i%2 == 0).forEach(System.out::println);
        numbers.stream().skip(1).limit(70).filter(i -> i%2 == 0).forEach(System.out::println);
    }
}

package stream.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListAnyMatchContains {
    public static void main(String[] args) {
//        matchAny();
//        skipAndLimit();
//        reduceList();

        getFirst();
    }

    private static void reduceList() {
        List<Integer> numbers = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());
        int sumResult = numbers.stream().reduce(0, (a, b) -> a + b); // 0 is starting value
//        int sumUsingReduce = numbers.stream().reduce(Integer::sum).get(); // Using reduce + method reference
        int sumUsingStream = numbers.stream().mapToInt(i -> i).sum(); // Using mapToInt
        System.out.println(sumResult);

        int maxValue = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b); // Returns max value in list
        System.out.println(maxValue);
    }

    private static void matchAny() {
        int match = 600000;
        List<Integer> numbers = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());
        boolean isMatchViaStream = numbers.stream().anyMatch(x -> x == match);
        System.out.println(isMatchViaStream);
    }

    private static void getFirst() {
        int match = 600000;
        Integer res = null;
        List<Integer> numbers = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());
        Optional<Integer> number = numbers.stream().filter(num -> num == match).findFirst();
        if (number.isPresent()) {
            res = number.get();
            System.out.println(res);
        }
//        System.out.println(res);
    }

    private static void skipAndLimit() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().skip(1).limit(70).filter(i -> i%2 == 0).forEach(System.out::println);
        numbers.stream().skip(1).limit(70).filter(i -> i%2 == 0).forEach(System.out::println);
    }

}

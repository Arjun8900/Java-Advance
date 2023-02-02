package stream.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListAnyMatchContains {
    public static void main(String[] args) {
        matchAny();
        skipAndLimit();
    }

    private static void matchAny() {
        int match = 600000;
        List<Integer> numbers = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());
        boolean isMatchViaStream = numbers.stream().anyMatch(x -> x == match);
        System.out.println(isMatchViaStream);
    }

    private static void skipAndLimit() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().skip(1).limit(70).filter(i -> i%2 == 0).forEach(System.out::println);
        numbers.stream().skip(1).limit(70).filter(i -> i%2 == 0).forEach(System.out::println);
    }

}

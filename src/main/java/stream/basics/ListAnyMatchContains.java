package stream.basics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListAnyMatchContains {
    public static void main(String[] args) {
        int match = 600000;
        List<Integer> numbers = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());
        long start = System.currentTimeMillis();
        boolean isMatch = false;
        for (int num: numbers) {
            if (num == match) {
                isMatch = true;
                break;
            }
        }
        System.out.printf("Match = %s, Time taken = %s %n", isMatch, System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        boolean isMatchViaStream = numbers.stream().anyMatch(x -> x == match);
        System.out.printf("Match = %s, Time taken = %s %n", isMatchViaStream, System.currentTimeMillis() - start);
    }
}

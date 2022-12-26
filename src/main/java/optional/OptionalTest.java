package optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> hello = Optional.ofNullable("df");
        hello.orElse("emptyu");


    }
}

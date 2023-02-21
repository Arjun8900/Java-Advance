package function_interface.inbuit_function;

import java.util.function.Function;

public class FuncInterfaceDefault {
    public static void main(String[] args) {
        applySimple();
        applyAndThen();

        applyTransformation();
    }

    private static void applySimple() {
        Function<Integer, Double> half = a -> a/2.0;
        Double res = half.apply(5);

        System.out.println(res);
    }
    private static void applyAndThen() {
        Function<Integer, Double> half = a -> a/2.0;
        half = half.andThen(a -> a * a);

        System.out.println(half.apply(5));
    }

    private static void applyTransformation() {
        Function<Input, Output> res = input -> {
            Output output = new Output();
            output.setX(input.getX());
            output.setY(input.getY());
            output.setMul(input.getX() * input.getY());
            return output;
        };

        System.out.println(res.apply(new Input(1, 2, "abc")));
    }
}

package generics.function;

public class GenericMethod {
    public static void main(String[] args) {
        shout("Hi");
        shout(123);
        shout(123.0);

        shout(123.0, "abs");
        shout("abs", 123.0);

    }
    public static <T> void shout(T shout) {
        T passing = shout;
        System.out.println(passing + "!!!");
    }

    public static <T, V> void shout(T shout, V otherThingToShout) {
        System.out.println(shout + "!!!"  + otherThingToShout);
    }
}

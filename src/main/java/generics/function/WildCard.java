package generics.function;

import generics.classes.extending.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCard {
    public static void main(String[] args) {
        unboundedWildCards();

    }

    private static void unboundedWildCards() {
        List<String> strings = Arrays.asList("abc", "xyz");
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);

        shoutUnBounded(strings);
        shoutUnBounded(ints);
    }

    public static void shoutUnBounded(List<?> shout) {
        System.out.println(shout + "!!!");
    }

    public static void boundedWildCards() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());
        shoutBounded(cats);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        shoutBounded(dogs);
    }
    public static void shoutBounded(List<? extends Animal> shout) {
        System.out.println(shout + "!!!");
    }
}

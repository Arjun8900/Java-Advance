package generics.function;

import generics.classes.data.Animal;
import generics.classes.data.Cat;
import generics.classes.data.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCardMethod {
    public static void main(String[] args) {
        unboundedWildCards();

        boundedWildCards();
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
        for (Animal a: shout) {
            a.eat();
        }
        System.out.println(shout.size() + "!!!");
    }
}

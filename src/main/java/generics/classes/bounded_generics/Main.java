package generics.classes.bounded_generics;


import generics.classes.data.Animal;
import generics.classes.data.Cat;
import generics.classes.data.Dog;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnimalPrinter<Cat> catAnimalPrinter = new AnimalPrinter<>();
        catAnimalPrinter.addItem(new Cat());
        catAnimalPrinter.addItem(new Cat());
        catAnimalPrinter.print();

        AnimalPrinter<Dog> dogAnimalPrinter = new AnimalPrinter<>();
        dogAnimalPrinter.addItem(new Dog());
        dogAnimalPrinter.addItem(new Dog());
        dogAnimalPrinter.print();
    }
}

class AnimalPrinter <T extends Animal> {
    List<T> animals = new ArrayList<>();

    public void addItem(T item) {
        animals.add(item);
    }

    public T getItem(int i) {
        if (i < animals.size()) {
            return animals.get(i);
        }
        return null;
    }

    public void print() {
        for (T g: animals) {
            g.eat(); // Since Animal or its children must be having eat().
        }
    }
}

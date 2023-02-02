package generics.classes.extending;

import java.util.ArrayList;
import java.util.List;

public class AnimalPrinter <T extends Animal> {
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

package generics.classes;

import java.util.ArrayList;
import java.util.List;

public class ListGeneric<T> {
    private final List<T> genericList = new ArrayList<>();

    public void addItem(T item) {
        genericList.add(item);
    }

    public T getItem(int i) {
        if (i < genericList.size()) {
            return genericList.get(i);
        }
        return null;
    }
}

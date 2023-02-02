package generics.classes;

import java.util.List;

public class ListGeneric<T> {
    private List<T> genericList;

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

package generics.classes.unbounded_generics;

public class ObjectGeneric<T> {
    private T type;

    public ObjectGeneric(T type) {
        this.type = type;
    }


    public void print() {
        System.out.println(type);
    }
}

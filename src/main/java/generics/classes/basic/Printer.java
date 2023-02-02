package generics.classes.basic;

public class Printer <T> {
    private T type;

    public Printer(T type) {
        this.type = type;
    }


    public void print() {
        System.out.println(type);
    }
}

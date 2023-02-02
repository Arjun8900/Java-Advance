package generics.classes.unbounded_generics;

public class Main {
    public static void main(String[] args) {
        // Single Generic
        ObjectGeneric<String> stringObjectGeneric = new ObjectGeneric<>("Strings");
        stringObjectGeneric.print();

        ObjectGeneric<Integer> integerObjectGeneric = new ObjectGeneric<>(1234);
        integerObjectGeneric.print();

        // List of Generics
        typeAsString();
        typeAsInteger();

    }

    private static void typeAsString() {
        ListGeneric<String> stringListGeneric = new ListGeneric<>();
        stringListGeneric.addItem("abc");
        stringListGeneric.addItem("xyz");
        stringListGeneric.print();
    }
    private static void typeAsInteger() {
        ListGeneric<Integer> stringListGeneric = new ListGeneric<>();
        stringListGeneric.addItem(1);
        stringListGeneric.addItem(2);
        stringListGeneric.print();

    }
}

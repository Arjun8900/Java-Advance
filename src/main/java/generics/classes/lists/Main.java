package generics.classes.lists;

public class Main {
    public static void main(String[] args) {
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

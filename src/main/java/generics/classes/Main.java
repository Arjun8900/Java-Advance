package generics.classes;

public class Main {
    public static void main(String[] args) {
        typeAsString();

    }

    private static void typeAsString() {
        ListGeneric<String> stringListGeneric = new ListGeneric<>();
        stringListGeneric.addItem("abc");
        stringListGeneric.addItem("xyz");
        System.out.println(stringListGeneric);
    }
}

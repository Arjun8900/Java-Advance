package future;


import generics.classes.ListGeneric;

public class CompatibleFutureObject {
    public static void main(String[] args) {

        ListGeneric<String> stringListGeneric = new ListGeneric<>();
        stringListGeneric.addItem("abc");
    }
}

package generics.classes.basic;

public class Main {
    public static void main(String[] args) {
        Printer<String> stringPrinter = new Printer<>("Strings");
        stringPrinter.print();

        Printer<Integer> integerPrinter = new Printer<>(1234);
        integerPrinter.print();
    }
}

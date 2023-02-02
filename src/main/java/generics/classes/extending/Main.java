package generics.classes.extending;


public class Main {
    public static void main(String[] args) {
        AnimalPrinter<Cat> catAnimalPrinter = new AnimalPrinter<>();
        catAnimalPrinter.addItem(new Cat());
        catAnimalPrinter.addItem(new Cat());
        catAnimalPrinter.print();

        AnimalPrinter<Dog> dogAnimalPrinter = new AnimalPrinter<>();
        dogAnimalPrinter.addItem(new Dog());
        dogAnimalPrinter.addItem(new Dog());
        dogAnimalPrinter.print();
    }
}

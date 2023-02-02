package generics.function;

public class Animal {

    public void eat() {
        System.out.println("Animal Eating");
    }
}
class Cat extends Animal{

    public void eat() {
        System.out.println("Cat Eating");
    }
}

class Dog extends Animal{

    public void eat() {
        System.out.println("Dog Eating");
    }
}

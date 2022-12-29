package annotations;


@MyAnnotation
public class Cat {
    @StringAnnotation
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @MyAnnotation(times = 3)
    public void meow() {
        System.out.println("Meow");
    }
    // Below class is not annotated
    public void silent() {
        System.out.println("No Meow");
    }
}

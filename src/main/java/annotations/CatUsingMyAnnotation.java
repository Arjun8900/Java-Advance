package annotations;


@ClassAnnotation
public class CatUsingMyAnnotation {
    @MethodAnnotation
    String name;

    public CatUsingMyAnnotation(String name) {
        this.name = name;
    }

    @ClassAnnotation(times = 3)
    public void meow() {
        System.out.println("Meow");
    }
    // Below class is not annotated
    public void silent() {
        System.out.println("No Meow");
    }
}

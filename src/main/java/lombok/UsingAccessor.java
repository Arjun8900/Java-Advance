package lombok;

public class UsingAccessor {

    public static void main(String[] args) {
        Person person = createPersonUsingChaining(1, "arjun", 29);
        System.out.println(person);
    }

    public static Person createPersonUsingChaining(int id, String name, int age) {
        return new Person().setId(id).setName(name).setAge(age);
    }
}

package optional.basic;

import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        printDefaultIfNull();
        ifPresent();
        createObjectIfNotFoundInList();

        throwCustomExceptionIfNull();

    }

    private static void ifPresent() {
        Optional<String> hello = Optional.ofNullable(null);
        // 1. ifPresent()
        hello.ifPresent(word -> {
            // Extra computation.
            System.out.println(word.toUpperCase());
        });

        // 2. orElseGet()
        String orElse = hello.map(String::toUpperCase).orElseGet(() -> {
            // Extra computation
            String defaultResponse = new String("default");
            return defaultResponse.toUpperCase();
        });
        System.out.println(orElse);
    }

    private static void createObjectIfNotFoundInList() {
        List<Customer> customers = Customer.getAll();  // customers = ["arjun@gmail.com", "kanwal@gmail.com"]

        // This email is not present, hence, orElse part will be executed.
        Customer defaultCustomer = getCustomerByEmailId(customers, "singh@gmail.com");
        System.out.println(defaultCustomer);
    }


    private static void throwCustomExceptionIfNull() {
        String name = null;
        Optional<String> emptyName = Optional.ofNullable(name);
        System.out.println(emptyName.orElseThrow(() -> new IllegalArgumentException("Email not present")));
    }

    private static void printDefaultIfNull() {
        Optional<String> hello = Optional.ofNullable(null);
        String empty = hello.orElse("default");
        System.out.println(empty);
    }

    private static Customer getCustomerByEmailId(List<Customer> customers, String email){

        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElse(new Customer(3, "default", "default@gmail.com"));
    }
}

package optional.basic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String email;

    public static List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer(1, "Arjun", "h1@gmail.com");
        Customer customer2 = new Customer(2, "Arjun", "h1@gmail.com");
        customers.add(customer1);
        customers.add(customer2);

        return customers;
    }
}

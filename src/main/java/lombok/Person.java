package lombok;

import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Person {

    private int id;

    private String name;

    private int age;

    private Date dob;
}

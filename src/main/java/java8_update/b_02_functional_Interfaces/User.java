package java8_update.b_02_functional_Interfaces;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private int age;

}

package java8_update.z_alumniB1_OOP.Encapsulation;

import java8_update.z_alumniB1_OOP.Inheritance.BaseEntity;
import java8_update.a_enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private Role role;
    private Gender gender;



}

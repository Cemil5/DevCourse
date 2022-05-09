package javaReview.alumniB1_OOP.Encapsulation;

import javaReview.alumniB1_OOP.Inheritance.BaseEntity;
import javaReview.enums.Gender;
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

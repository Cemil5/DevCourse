package com.example.lessons.z_alumniB1_OOP.Encapsulation;

import com.example.lessons.a_enums.Gender;
import com.example.lessons.z_alumniB1_OOP.Inheritance.BaseEntity;
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

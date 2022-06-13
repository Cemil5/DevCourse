package com.example.lessons.b_03_lambda.sorting;

import com.example.lessons.z_alumniB1_OOP.Encapsulation.Role;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Employee {

    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeCity;
    private Role role;


}

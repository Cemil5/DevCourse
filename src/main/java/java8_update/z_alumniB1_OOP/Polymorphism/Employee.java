package java8_update.z_alumniB1_OOP.Polymorphism;

import java8_update.z_alumniB1_OOP.Encapsulation.User;
import java8_update.z_alumniB1_OOP.Inheritance.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Employee extends BaseEntity {

    private int employeeId;
    private String employeeTask;
    private User employeeManager;

    public void getEmployeeHours(){
        System.out.println("40 hours a week");
    }

}

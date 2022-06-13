package com.example.lessons;

import com.example.lessons.a_enums.Gender;
import com.example.lessons.a_enums.Status;
import com.example.lessons.core.Loops;
import com.example.lessons.core.Methods;
import com.example.lessons.core.SelectionStatements;
import com.example.lessons.z_alumniB1_OOP.Abstraction.Implementation.UserServiceImplementation;
import com.example.lessons.z_alumniB1_OOP.Abstraction.Service.UserService;
import com.example.lessons.z_alumniB1_OOP.Encapsulation.Role;
import com.example.lessons.z_alumniB1_OOP.Encapsulation.User;
import com.example.lessons.z_alumniB1_OOP.Inheritance.BaseEntity;
import com.example.lessons.z_alumniB1_OOP.Inheritance.Project;
import com.example.lessons.z_alumniB1_OOP.Polymorphism.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // ********** CORE ******* //
        Methods methods = new Methods();
        methods.methodA();
        methods.methodA("Apple");
        System.out.println(methods.methodB());
        Methods.methodC();

        // ********** LOOP *******//
        Loops.demoForIterator();
        Loops.demoForEach();

        // ********** selection *******//
        SelectionStatements.demoIfStatement();
        SelectionStatements.demoSwitchCaseStatement();

        // ********** OOP encapsulation *******//
        User user = new User("Mike", "Smith", new Role(2,"manager"), Gender.MALE);
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getRole().getDescription());

        // ********** OOP encapsulation *******//

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime.getNano());
          Project project = new Project(1, LocalDateTime.now(),1,LocalDateTime.now().minusDays(10),
                  2590, "newProject","ProjectDev",
                  new User("Ozzy", "Man", new Role(2589, "manager"),Gender.MALE), LocalDate.now().plusDays(6),
                  LocalDate.now().plusMonths(12), Status.IN_PROGRESS, 123456);

        System.out.println("project = " + project.toString());

        // ********** OOP abstraction : interface *******//

        UserService userService = new UserService();
        System.out.println(userService.userByFirstName("Mike").getLastName());

        // ********** OOP polymorphism *******//

        Employee employee = new Employee();
        BaseEntity employee2 = new Employee();

        UserServiceImplementation userServiceImplementation = new UserService();

        employee.getEmployeeHours();

        ((Employee) employee2).getEmployeeHours(); // down casting

        // ********** ENUM *******//

        System.out.println(Gender.FEMALE);

        System.out.println(Status.IN_PROGRESS.getValue().substring(3));

    }



}

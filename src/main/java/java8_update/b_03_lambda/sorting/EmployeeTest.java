package java8_update.b_03_lambda.sorting;

import java8_update.z_alumniB1_OOP.Encapsulation.Role;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Mike", "smith", "VA", new Role(1, "Developer"));
        Employee e2 = new Employee(10, "Mike1", "smith2", "VA3", new Role(5, "SDET"));
        Employee e3 = new Employee(5, "Mike11", "smith22", "VA33", new Role(8, "DBA"));
        Employee e4 = new Employee(1, "Mike111", "smith222", "VA333", new Role(18, "SM"));
        Employee e5 = new Employee(50, "Mike5", "smith5", "VA5", new Role(9, "SM5"));

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        System.out.println(employeeList.toString());

        employeeList.sort((emp1, emp2) -> emp1.getEmployeeId().compareTo(emp2.getEmployeeId()));
        employeeList.sort(Comparator.comparing(Employee::getEmployeeId));
        System.out.println(employeeList);

      //  employeeList.sort((emp1, emp2) -> emp1.getRole().getId().compareTo(emp2.getRole().getId()));
      //  employeeList.sort(Comparator.comparing(Employee::getRole));
    }
}

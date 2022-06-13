package com.example.streampracticetask;

import com.example.streampracticetask.practice.Practice;
import com.example.streampracticetask.practice.PracticeWithAnswers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamPracticeTaskApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StreamPracticeTaskApplication.class, args);
        System.out.println("Practice.getSecondMaxSalary() = " + Practice.getSecondMaxSalary());
        System.out.println("PracticeWithAnswers.getSecondMaxSalary() = " + PracticeWithAnswers.getSecondMaxSalary());
        System.out.println("Practice.getSecondMaxSalaryEmployee() = " + Practice.getSecondMaxSalaryEmployee());
        // Practice.getMinSalaryEmployee();
        System.out.println("Practice.getAllEmployeesFullNames() = " + Practice.getAllEmployeesFullNames());

    }

}

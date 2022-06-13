package com.example.lessons.b_02_functional_Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserTest {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(User.builder().firstName("Mike").lastName("Smith").age(35).build());
        users.add(User.builder().firstName("Tom").lastName("Hanks").age(55).build());
        users.add(User.builder().firstName("Ammy").lastName("Evan").age(15).build());
        users.add(User.builder().firstName("Emma").lastName("Pellard").age(25).build());

        //Print all elements in the list
//        printName(users, p -> true);

        printName(users, p -> true);

        System.out.println("****************************");

        //Print all users that last name starts with E
        printName(users, user -> user.getLastName().startsWith("E"));

        System.out.println("************ AGE ****************");

        printName(users, user -> user.getAge() > 50);


    }

    private static void printName(List<User> users, Predicate<User> p){
        for(User user : users){
            if(p.test(user)){
                System.out.println(user);
            }
        }
    }
}

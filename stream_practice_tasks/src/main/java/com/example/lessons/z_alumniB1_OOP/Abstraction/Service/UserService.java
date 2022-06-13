package com.example.lessons.z_alumniB1_OOP.Abstraction.Service;

import com.example.lessons.a_enums.Gender;
import com.example.lessons.z_alumniB1_OOP.Abstraction.Implementation.UserServiceImplementation;
import com.example.lessons.z_alumniB1_OOP.Encapsulation.Role;
import com.example.lessons.z_alumniB1_OOP.Encapsulation.User;

public class UserService implements UserServiceImplementation {


    @Override
    public String userByRoleId(int id) {
        User user = new User("Mike","Smith", new Role(id, "Admin"), Gender.MALE);
        return user.getFirstName() + " " + user.getLastName();
    }

    @Override
    public User userByFirstName(String firstName) {
        User user = new User(firstName,"Smith", new Role(1, "Admin"), Gender.MALE);
        return user;
    }
}

package java8_update.z_alumniB1_OOP.Abstraction.Service;

import java8_update.z_alumniB1_OOP.Abstraction.Implementation.UserServiceImplementation;
import java8_update.z_alumniB1_OOP.Encapsulation.Role;
import java8_update.z_alumniB1_OOP.Encapsulation.User;
import java8_update.a_enums.Gender;

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

package JavaReview.OOP.Abstraction.Service;

import JavaReview.OOP.Abstraction.Implementation.UserServiceImplementation;
import JavaReview.OOP.Encapsulation.Role;
import JavaReview.OOP.Encapsulation.User;
import JavaReview.enums.Gender;

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

package JavaReview.Collections;

import JavaReview.OOP.Encapsulation.Role;

import java.util.ArrayList;
import java.util.List;

public class ArrayListReview {

    public static void createList(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);
        list.add(20);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
/*
    public static void createUserList(){
        List<User> userList = new ArrayList<User>();
        User user1 = new User("Mike","Smith",new Role(1, "Manager"), Gender.MALE);
        userList.add(user1);
        userList.add(new User("Ammy","Taylor",new Role(2, "Admin"), Gender.FEMALE));

        for (User user : userList) {
            System.out.println(user.getRole().getDescription());
        }
    }
 */

    public static List<Role> createRoleList(){
        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(1,"Manager"));
        roleList.add(new Role(2,"Employee"));
        roleList.add(new Role(3,"Employee"));
        roleList.add(new Role(4,"Employee"));
        roleList.add(new Role(5,"Admin"));
        return roleList;
    }

}

package JavaReview.streams;

import JavaReview.Collections.ArrayListReview;
import JavaReview.OOP.Encapsulation.Role;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingStream {
    public static void main(String[] args) {

        // Creating stream from an Array
        String[] courses = {"Java", "JS", "TS", "API","SELENIUM"};
        Stream<String> courseStream = Arrays.stream(courses);

        // Creating a stream from a collection
        Stream<Role> roleStream = ArrayListReview.createRoleList().stream();

        // Creating a stream from specified values
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8);

        System.out.println(stream);

    }


}

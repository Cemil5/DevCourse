package com.example.lessons.b_05_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class a01_CreatingStream {

    public static void main(String[] args) {

        //Creating Stream from Array
        String[] courses = {"Java","JS","TS"};
        Stream<String> courseStream = Arrays.stream(courses);

        //Creating Stream from Collection
        List<String> courseList = Arrays.asList("Java","DS","Spring");
        Stream<String> courseStream2 = courseList.stream();

        List<a02_Course> myCourses = Arrays.asList(
                new a02_Course("Java",100),
                new a02_Course("DS",101),
                new a02_Course("Spring",102),
                new a02_Course("Microservices",103)
        );

        Stream<a02_Course> myCourseStream = myCourses.stream();

        //Creating Stream from Values
        Stream<Integer> stream = Stream.of(1,2,3,4);
    }
}

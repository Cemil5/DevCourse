package java8_update.Collections;

import java8_update.b_01_behaviorParameterization.apple.Apple;
import java8_update.b_01_behaviorParameterization.apple.Color;

import java.util.*;

public class ArrayListReview {
    public static void main(String[] args) {
        // Create ArrayList and a class
        List<Student> students= new ArrayList<>();
        // Add Elements to ArrayList
        students.add(new Student(1,"Jose"));
        students.add(new Student(2,"Sayed"));
        students.add(new Student(3,"Nick"));
        students.add(new Student(4,"Ronnie"));
        System.out.println(students);

        // alternative way of adding to list
        List<Apple> inventory1 = new ArrayList<>(List.of(
                new Apple(300, Color.GREEN),
                new Apple(100, Color.RED),
                new Apple(200, Color.GREEN),
                new Apple(50, Color.RED)
        ));
        inventory1.add(new Apple(150, Color.RED));
        inventory1.forEach(System.out::println);



        // Forward Iteration
        Iterator<Student> iter= students.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        // Backwards Iteration
        while(((ListIterator<?>) iter).hasPrevious()){
            System.out.println(((ListIterator<?>) iter).previous());
        }


        // 3. for each loop
        System.out.println("Printing For each loop..........");
        for(Student student:students) System.out.println(student);

        System.out.println("Printing with Lambda..........");
        // 4. Lambda
        students.forEach(student -> System.out.println(student) );
        // Sorting Elements in List
        System.out.println("Printing with sorted List by comp..........");
        Collections.sort(students,new sortByIdDesc());
        System.out.println(students);
        System.out.println("Printing with sorted List by Name Desc..........");
        Collections.sort(students,new sortByNameDesc());
        System.out.println(students);


    }
    static class sortByIdDesc implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id-o2.id;
        }
    }
    static class sortByNameDesc implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o2.name.compareToIgnoreCase(o1.name);
        }
    }


}

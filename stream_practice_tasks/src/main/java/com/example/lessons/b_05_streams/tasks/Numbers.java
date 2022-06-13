package com.example.lessons.b_05_streams.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {

    /*
    Given a list of numbers how would you return a list of the square of each
number? For example, given [1,2,3,4,5] you should return [1,4,9,16,25]
     */
    // int[] ints = {1,2,3,4,5};     hata verdi.
    static List<Integer> list = List.of(1, 2, 3, 4, 5);
    static List<Integer> result = list.stream()
            .map(operand -> operand * operand)
            .collect(Collectors.toCollection(ArrayList::new));

    /*
    Given two lists of numbers, how would you return all pairs of numbers? For
example, given a list [1,2,3] and a list [3,4] you should return [(1,3),(1,4),(2,3),
(2,4),(3,3),(3,4)]
List<Integer> numbers1 = Arrays.asList(1,2,3);
List<Integer> numbers2 = Arrays.asList(3,4);
List<int[]> pairs = ?????
     */

//    static List<int[]> numPairs() {
//        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//        List<Integer> numbers2 = Arrays.asList(3, 4);
//        List<List<Integer>> nums = new ArrayList<>();
//        nums.add(numbers1);
//        nums.add(numbers2);
//        List<int[]> pairs = nums.stream()
//                .map((a, b) -> {
//                    new int[]{a};
//                    new int[]{b}};
//                return )
//                .map((a, b) -> new int[]{a, b})
//                .collect(Collectors.toList());
//    }

    /*
    How would you count the number of dishes in a stream using the map
and reduce methods?
     */

    long reduceDish() {
        // return DishData.getAll().stream().map(d -> 1).reduce(0, (a, b) -> a+b);  // same
        // return DishData.getAll().stream().map(d -> 1).reduce(0, Integer::sum);   // same
        return DishData.getAll().stream().count();   // same
    }

    public static void main(String[] args) {
        System.out.println("square of list : " + result);

        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::print);

    }
}

package com.example.lessons.b_05_streams;

import com.example.lessons.b_05_streams.tasks.DishData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4,5,3,9);
        int result = numbers.stream().reduce(0,(a,b) -> a+b);       // same
        int result21 = numbers.stream().reduce(0, Integer::sum);    // same
        System.out.println(result);

        //No initial value
        Optional<Integer> result2 = numbers.stream().reduce((a, b) -> a+b); // same
        Optional<Integer> result22 = numbers.stream().reduce(Integer::sum); // same
        System.out.println(result2);

        //Max and Min
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
        System.out.println("Sum:" + sum.get());

        System.out.println("Min:" + min.get());
        System.out.println("Max:" + max.get());

        //Task
        int dishCount = DishData.getAll().stream().map(d -> 1).reduce(0,(a, b) -> a+b);
        System.out.println(dishCount);

        long dcount = DishData.getAll().stream().count();
        System.out.println(dcount);



    }
}

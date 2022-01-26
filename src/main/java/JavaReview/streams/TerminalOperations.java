package JavaReview.streams;

import JavaReview.Collections.ArrayLists;
import JavaReview.OOP.Encapsulation.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {

        System.out.println("*************** COUNT *************");
        Integer[] numbersArray = {1,2,3,4,5,6,7,8,9,10};
        Stream<Integer> numbersStream = Arrays.stream(numbersArray);
        long count = numbersStream.count();
        System.out.println(count);

        long count1 = Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream().filter(str -> str.equals("Apple")).count();
        System.out.println(count);

        System.out.println("*************** FIND FIRST - FIND ANY *************");
        Role r = ArrayLists.createRoleList().stream().filter(role -> role.getDescription().equals("Employee")).findFirst().get();
        System.out.println(r.getId());

        Role r2 =
                ArrayLists.createRoleList().stream().filter(role -> role.getDescription().equals("Employee")).findAny().get();
        System.out.println(r.getId());

        System.out.println("*************** COLLECT *************");

        List<String> appleList =
                Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream().filter(s -> s.equals("Apple")).collect(Collectors.toList());

        System.out.println(appleList);

        System.out.println((long) appleList.size());

        System.out.println("*************** REDUCE *************");
        Integer total = Arrays.asList(3, 4, 5, 6, 12, 20).stream().reduce(5, (x, y) -> x + y);
        Integer total1 = Stream.of(3, 4, 5, 6, 12, 20).reduce(5, Integer::sum);
        System.out.println(total);

        String word = Arrays.asList("C", "Y", "B", "E", "R", "T", "E", "K").stream().reduce("", (a, b) -> a + b);
        System.out.println(word);

    }
}

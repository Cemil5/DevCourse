package java8_update.b_05_streams.alumni_B1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {

        Integer[] numbersArray = {1,2,3,4,5,6,7,8,9,10};
        Stream<Integer> numbersStream = Arrays.stream(numbersArray);

        System.out.println("*************** FILTER *************");

        // filter
        System.out.println(numbersStream.filter(number -> number % 2 != 0).count());


        Stream<String> strStream =
                Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream();
        System.out.println(strStream.filter(str -> str.length() == 5).count());

      //  strStream.filter(str -> str.startsWith("A")).count(); // ERROR

        Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream().filter(str -> str.equals("Apple")).forEach(str -> System.out.println(str));
        Stream.of("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").filter(str -> str.equals("Apple")).forEach(System.out::println);

        System.out.println("*************** MAP *************");

        Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream().map(str -> str.toUpperCase(Locale.ROOT)).forEach(System.out::println);

        System.out.println("*************** distinct *************");
        Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream().distinct().forEach(System.out::println);

        System.out.println("*************** SORTED ORDER *************");
        Arrays.asList(numbersArray).stream().sorted().forEach(System.out::println);

        System.out.println("*************** SORTED REVERSED ORDER *************");
        Arrays.stream(numbersArray).sorted(Comparator.reverseOrder()).forEach(System.out::println);


    }

}

package java8_update.b_02_functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Examples {

    public static void main(String[] args) {

        //************PREDICATE******************//
        // anonymous class
        Predicate<Integer> lesserThan = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 18;
            }
        };

        lesserThan.test(50);

        Predicate<Integer> lesserThan1 = b -> b < 18; //Implementation of test method that belongs to Predicate interface
        Boolean result = lesserThan1.test(50);
        System.out.println(result);

        System.out.println("//************CONSUMER******************//");
        Consumer<Integer> display = i -> System.out.println(i);
        Consumer<Integer> display1 = System.out::println;   // same with display
        display.accept(50);

        // my test 28.05.2022
        Consumer<List<Integer>> c = System.out::println;
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        c.accept(list);
        int[] i5 = {1, 2, 3, 5, 7};
        System.out.println(i5);
        Consumer<int[]> c5 = a -> System.out.println(Arrays.toString(a));
        c5.accept(i5);

        //************BICONSUMER******************//
        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
        addTwo.accept(100, 200);

        //************FUNCTION******************//
        Function<String, String> fun = s -> "Hello " + s;
        String str = fun.apply("Ozzy");
        System.out.println(str);

        System.out.println(fun.apply("Apple"));

        //************SUPPLIER******************//
        Supplier<Double> randomValue = () -> Math.random();
        Supplier<Double> randomValue1 = Math::random;
        System.out.println(randomValue.get());


        Predicate<Integer> pred = (p) -> p % 2 == 0 ? true : false;
        Predicate<Integer> pred1 = (p) -> p % 2 == 0;
        System.out.println(pred.test(10));

        BiConsumer<Integer, String> bn = (x, y) -> System.out.println(x + y);
        bn.accept(5, "apple");


    }
}

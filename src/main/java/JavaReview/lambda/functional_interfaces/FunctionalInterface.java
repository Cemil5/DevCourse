package JavaReview.lambda.functional_interfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {

    public static void main(String[] args) {

        // accepts a single parameter and returns a single value
        Function<Integer, Double> half = a -> a/2.0;
        System.out.println(half.apply(10));

        // does not accept any arguments and returns an object
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

        // accepts a single argument and does not return any result
        Consumer<Integer> display = a -> System.out.println(a);
        display.accept(10);

        // accepts a single argument and returns true or false
        Predicate<Integer> lesserThan = i -> (i<10);
        lesserThan.test(5);

    }

}

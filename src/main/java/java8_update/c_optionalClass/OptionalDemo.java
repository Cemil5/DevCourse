package java8_update.c_optionalClass;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2,4,10,23);

        // empty() isPresent()
        Optional<String > empty = Optional.empty();
        System.out.println(empty.isPresent());
        System.out.println(Optional.of(numbers).isPresent());

        //ifPresent
        Optional<Integer> bigNumber = numbers.stream().filter(x -> x>100).findAny();
        System.out.println(bigNumber);
        bigNumber.ifPresent(System.out::println);

        //get
        //   System.out.println(bigNumber.get());
        bigNumber.ifPresent(integer -> bigNumber.get());

        //orElse
        System.out.println(bigNumber.orElse(0));


    }



}

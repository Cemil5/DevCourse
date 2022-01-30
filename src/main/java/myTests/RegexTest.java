package myTests;

import java.util.Arrays;

public class RegexTest {
    public static void main(String[] args) {
        int[] array = {1,2,5,};
        System.out.println(Arrays.binarySearch(array, 3));

        String email = "example@gmail.com";
     //   \b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}\b

        System.out.println("email check: " + email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$"));


        String regex = "\\d{1,2}D\\d{1,2}H\\d{1,2}M";
        String str = "25D8H15M";

        System.out.println("day check1: " + str.matches(regex));
        System.out.println("day check2: " + str.matches("^\\d{1,2}D\\d{1,2}H\\d{1,2}M$"));


    }
}

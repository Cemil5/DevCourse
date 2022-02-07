package myTests;

import java.util.Arrays;

public class RegexTest {
    public static void main(String[] args) {
        int[] array = {1,2,5,};
        System.out.println(Arrays.binarySearch(array, 3));

        //   \b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}\b

        //    System.out.println("email check: " + email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$"));

        String email = "example@gmail.com";

        // Simplest regex to validate email
        System.out.println("email check: " + email.matches("^(.+)@(.+)$"));

        //  Java email validation permitted by RFC 5322
        System.out.println("email check: " + email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"));
        // https://howtodoinjava.com/java/regex/java-regex-validate-email-address/


        String regex = "\\d{1,2}D\\d{1,2}H\\d{1,2}M";
        String str = "25D7H15M";

        System.out.println("day check1: " + str.matches(regex));
        System.out.println("day check2: " + str.matches("^\\d{1,2}D\\d{1,2}H\\d{1,2}M$"));


    }
}

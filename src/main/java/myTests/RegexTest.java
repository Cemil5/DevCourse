package myTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("email check: " + email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@(?!-)[a-zA-Z0-9.-]+$"));
        // https://howtodoinjava.com/java/regex/java-regex-validate-email-address/


        List<String> emails = new ArrayList<>();
        emails.add("user@domain.com");
        emails.add("user@domain.co.in");
        emails.add("user.name@domain.com");
        emails.add("user'name@domain.co.in");

//Invalid emails
        emails.add(".username@yahoo.com");
        emails.add("username@yahoo.com.");
        emails.add("username@yahoo..com");

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern = Pattern.compile(regex);

        for(String email1 : emails){
            Matcher matcher = pattern.matcher(email1);
            System.out.println(email1 +" : "+ matcher.matches());
        }


        String regex1 = "\\d{1,2}D\\d{1,2}H\\d{1,2}M";
        String str = "25D7H15M";

        System.out.println("day check1: " + str.matches(regex1));
        System.out.println("day check2: " + str.matches("^\\d{1,2}D\\d{1,2}H\\d{1,2}M$"));


    }
}

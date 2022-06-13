package myTests;

import java.util.*;
import java.util.stream.Stream;

public class StreamTests {
    public static void main(String[] args) {
//        Consumer<Integer> display = i -> {
//            month("January");
//            eligibleToVote(i, true);
//            eligibleToVote1(i, true);
//            guessNumber("test");
//            System.out.println(i);
//        };
//        display.accept(50);


        Stream<String> st = Stream.of("1",
                "2");

        st.forEach(str -> System.out.println(str));

      /*  System.out.println("********************************************");

        Map<Integer, Boolean> map = new HashMap<>();
        map.put(3, true);
        map.put(13, true);
        map.put(23, true);
        map.put(33, true);
        map.put(43, true);

     //   map.entrySet().stream().forEach((i) -> eligibleToVote(i.getKey(), i.getValue()));

        map.entrySet().forEach((i) -> eligibleToVote(i.getKey(), i.getValue()));
*/
   //    System.out.println("********************************************");

        List<String> list = Arrays.asList("February", "may", "june");

//        list.stream().forEach(st2 -> {month(st2);
//        monthDays(st2);});

        System.out.println("********************************************");

        Stream<String> stream = Stream.of("February", "may", "june");

        stream.forEach(s5 -> {
            list.stream().forEach(System.out::println);
            monthDays(s5);
        });



    }



    public static void eligibleToVote1(int age, boolean isAmerican) {

        if (age >= 18 && isAmerican == true) {
            System.out.println("You are eligible to vote");
        } else {
            System.out.println("You are not eligible to vote");
        }
    }

    public static void eligibleToVote(int age, boolean isAmerican) {

        boolean isEligible;

        isEligible = (age >= 18 && isAmerican == true) ? true : false;    // simplify

        if (isEligible) {
            System.out.println("You are eligible to vote");
        } else {
            System.out.println("You are not eligible to vote");
        }
    }

    public static void month(String monthName) {
        int numDays = 0;

        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();

        if (monthName.equals("January")) {
            numDays = 31;
        } else if (monthName.equals("February")) {
            numDays = 28;
        } else if (monthName.equals("March")) {
            numDays = 31;
        } else if (monthName.equals("April")) {
            numDays = 30;
        } else if (monthName.equals("May")) {
            numDays = 31;
        } else if (monthName.equals("June")) {
            numDays = 30;
        } else if (monthName.equals("July")) {
            numDays = 31;
        } else if (monthName.equals("August")) {
            numDays = 31;
        } else if (monthName.equals("September")) {
            numDays = 30;
        } else if (monthName.equals("October")) {
            numDays = 31;
        } else if (monthName.equals("November")) {
            numDays = 28;
        } else if (monthName.equals("December")) {
            numDays = 31;
        } else {
            numDays = 0;
        }

        if (numDays != 0) {
            System.out.println(monthName + " has " + numDays + " days.");
        } else {
            System.out.println(monthName + " is wrong month.");
        }
    }

    public static void monthDays(String monthName) {
        String days = "";
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();

        if (monthName.equals("January") || monthName.equals("March") ||
                monthName.equals("May") || monthName.equals("July") ||
                monthName.equals("August") || monthName.equals("October")
                || monthName.equals("December")) {
            days = "31 days";
        } else if (monthName.equals("February")) {
            days = "28 days";
        } else if (monthName.equals("April") || monthName.equals("June") ||
                monthName.equals("September") || monthName.equals("November")) {
            days = "30 days";
        } else {
            days = "month is invalid";
        }

        System.out.println(monthName + " has " + days);
    }



    public static void guessNumber(String str) {
        Scanner sc = new Scanner(System.in);
        //  int target = 50;
        int target = (int) (Math.random() * 100);
        // System.out.println(target);
        System.out.println("Enter your estimation");
        int guess = sc.nextInt();
        int count = 1;
        while (guess != target) {
            if (guess > target) {
                System.err.println("Your estimation is greater than target number.");
            } else {
                System.err.println("Your estimation is less than target number.");
            }
            System.out.println("Re-enter your estimation : ");
            guess = sc.nextInt();
            count++;
        }
        System.out.println("Your estimation is correct at " + count + " try.");
        sc.close();
    }

}

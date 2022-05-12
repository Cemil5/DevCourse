package z2Hero_Questions;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any Year:");
        int year = scan.nextInt();
        boolean isLeap;

        if(year % 4 == 0){
            if( year % 100 == 0){
                isLeap = year % 400 == 0;
            } else {
                isLeap = true;
            }
        } else {
            isLeap = false;
        }

        if(isLeap)
            System.out.println(year + " is a Leap Year.");
        else
            System.out.println(year + " is not a Leap Year.");
    }

    //   test();
   // test1();

    static void test () {
            int year = 1900;
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println("leap year");
            } else
                System.out.println("not leap");
        }

    static void test1 () {
        int year = 1900;
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ?  true : false;
//        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
//            System.out.println("leap year");
//        } else
//            System.out.println("not leap");
        System.out.println(isLeap);
    }

}

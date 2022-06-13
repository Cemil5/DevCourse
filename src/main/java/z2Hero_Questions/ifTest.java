package z2Hero_Questions;

import java.util.Scanner;

public class ifTest {
    public static void main(String[] args) {
        int grade = 90;
//        if (grade <= 100 && grade >= 90) {
//            System.out.println("You’ve got an A");
//        } else if (grade <= 90 && grade >= 80) {
//            System.out.println("You’ve got a B");
//        } else if (grade <= 70 && grade >= 60) {
//            System.out.println("You’ve got a C");
//        } else if (grade <= 60 && grade >= 50) {
//            System.out.println("You’ve got a D");
//        } else if (grade <= 50) {
//            System.out.println("You’ve got an F");
//        }

        test(90);
    }

    /*
        if the grade is bigger than or equals to 90 output excellent
        if the grade is bigger than or equals to 70 and smaller than 90 output good
        if the grade is bigger than or equals to 60 and smaller than 70 output pass
        if the grade is smaller than 60 output fail
     */
    static void test(int grade) {
        if (grade <= 100 && grade >= 90) {
            System.out.println("You’ve got an A");
        } else if (grade >= 80) {
            System.out.println("You’ve got a B");
        } else if (grade >= 70) {
            System.out.println("You’ve got a C");
        } else if (grade >= 60 && grade >= 50) {
            System.out.println("You’ve got a D");
        } else if (grade <= 50) {
            System.out.println("You’ve got an F");
        }
    }

    static void test2(int grade) {

        if (grade <= 100 && grade >= 90) {
            System.out.println("excellent");
        } else if (grade <= 90 && grade >= 70) {
            System.out.println("good");
        } else if (grade <= 70 && grade >= 60) {
            System.out.println("pass");
        } else if (grade <= 60 && grade >= 50) {
            System.out.println("fail");
        }

    }

    static void test3(int grade) {
        String result = "";
        if (grade <= 100 && grade >= 0) {
            if (grade >= 90) {
                result = "excellent";
            } else if (grade >= 70) {
                result = "good";
            } else if (grade >= 60) {
                result = "pass";
            } else {
                result = "fail";
            }
        } else {
            result = "invalid input";
        }
        System.out.println(result);
    }

    static void test4(int maxSpeed1){

        Scanner sc = new Scanner(System.in);
        int maxSpeed = sc.nextInt();
        System.out.println("Enter the speed of car: ");

        if (maxSpeed >= 200){
            System.out.println("This is fast car");
        } else if (maxSpeed < 200){
            System.out.println("This is NOT fast car");
        }
    }

    static void test5(int maxSpeed1){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the speed of car: ");
        int maxSpeed = sc.nextInt();

        if (maxSpeed >= 200){
            System.out.println("This is fast car");
        } else {
            System.out.println("This is NOT fast car");
        }
    }

    static void test6(int maxSpeed1){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the speed of car: ");
        int maxSpeed = sc.nextInt();

        System.out.println(maxSpeed >= 200 ? "This is fast car" : "This is NOT fast car");

    }
}

package z2Hero_Questions;

import java.util.Scanner;

//1. Create a class named CrewAndPassangers1
//        Given a number of people on the ship (int number)
//        determine how many need to be crew members and how many can be passengers.
//        Print how many of each type there should be.
//
//            Total: 50  ====> 20 crew, 30 passengers
//            Total: 75  ====> 25 crew, 50 passengers
//            Total: 100 ====> 30 crew, 70 passengers
//            Any other number of people on the ship is not valid
//
//        Solution1: Use ternary. Do not use more than one println()
//        Solution2: Use switch statement. Do not use more than one println()
//
//
//    2.Create a class named NumberOfDays, an integer variable named month is given,
//    Use switch statement to write a program that can find the number of days in the given number of month.
//
//            EX:
//                month = 5
//            output:
//                31 days
//            (Assume that February has 28 days)
//
//        Hints:
//            Months that has 31 days: 1, 3, 5, 7, 8, 10, 12
//            Months that has 30 days: 4, 6, 9, 11
public class NumberOfDays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte month;

        do {
            month = s.nextByte();
            byte day;

            switch (month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    day = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    day = 30;
                    break;
                case 2:
                    day = 28;
                    break;
                default:
                    day = 0;
            }

            System.out.println(day > 0 ? "day : " + day : "invalid number");
        } while (month >= 0 );
        s.close();
    }
}

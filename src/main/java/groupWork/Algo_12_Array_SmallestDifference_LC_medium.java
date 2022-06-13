package groupWork;

import java.util.Arrays;

/*
Question # 12
Description: Smallest Difference
Difficulty: Medium Category: Arrays
Write a function that takes in two non-empty arrays of integers, finds the pair of numbers
(one from each array) whose absolute difference is closest to zero, and returns an array
containing these two numbers, with the number from the first array in the first position.
Note that the absolute difference of two integers is the distance between them on the real
number line. For example, the absolute difference of -5 and 5 is 10, and the absolute
difference of -5 and -4 is 1. You can assume that there will only be one pair of numbers with
the smallest difference.
Sample Input
arrayOne = [-1, 5, 10, 20, 28, 3]
arrayTwo = [26, 134, 135, 15, 17]
Sample Output
[28, 26]
 */
public class Algo_12_Array_SmallestDifference_LC_medium {
    public static void main(String[] args) {
        int[] ar1 = {-1, 5, 10, 20, 28, 3};
        int[] ar2 = {26, 134, 135, 15, 17};
        System.out.println(Arrays.toString(findSmallestDifference(ar1, ar2)));

    }
    // my solution
    public static int[] findSmallestDifference(int[] ar1, int[] ar2){
        int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int a1 : ar1) {
            for (int a2 : ar2) {
                long resultDif = Math.abs((long) result[0] - (long) result[1]);
                long currentDif = Math.abs((long) a1 - (long) a2);
                if (resultDif > currentDif) result = new int[]{a1, a2};
            }
        }
        return result;
    }
}

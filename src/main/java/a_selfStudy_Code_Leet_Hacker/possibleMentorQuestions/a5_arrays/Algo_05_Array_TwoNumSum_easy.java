package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a5_arrays;

import java.util.*;

/*
Question # 5
Difficulty: Easy
Two Number Sum
Write a function that takes in a non-empty array of distinct integers and an
integer representing a target sum. If any two numbers in the input array sum up to the target
sum, the function should return them in an array, in any order. If no two numbers sum up to
the target sum, the function should return an empty array. Note that the target sum has to be
obtained by summing two different integers in the array; you can't add a single integer to itself
in order to obtain the target sum. You can assume that there will be at most one pair of
numbers summing up to the target sum.
Sample Input
array = [3, 5, -4, 8, 11, 1, -1, 6]
targetSum = 10
Sample Output
[-1, 11] // the numbers could be in reverse order
 */
public class Algo_05_Array_TwoNumSum_easy {
    public static void main(String[] args) {
        int[] distinct = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        System.out.println(Arrays.toString(twoNumberSum(distinct, targetSum)));
        System.out.println(Arrays.toString(twoNumberSum2(distinct, targetSum)));
    }

    // my first solution
    public static int[] twoNumberSum(int[] distinct, int targetSum){
        for (int i = 0; i<distinct.length; i++){
            for (int j = i +1; j<distinct.length;j++){
                if(distinct[i] + distinct[j] == targetSum) {
                    return new int[]{distinct[i], distinct[j]};
                }
            }
        }
        return new int[2];
    }


    // after udemy
    public static int[] twoNumberSum2(int[] distinct, int targetSum){
        Set<Integer> set = new HashSet<>();
        set.add(distinct[0]);
        for (int i = 1; i<distinct.length; i++){
            int key = targetSum-distinct[i];
            if (set.contains(key)){
                return new int[]{key, distinct[i]};
            } else {
                set.add(distinct[i]);
            }
        }
        return new int[2];
    }

    // after udemy : finds index of these numbers
    public static int[] twoNumberSum3(int[] distinct, int targetSum){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(distinct[0], 0);
        for (int i = 1; i<distinct.length; i++){
            int key = targetSum-distinct[i];
            if (map.containsKey(key)){
                return new int[]{map.get(key), i};
            } else {
                map.put(distinct[i], i);
            }
        }
        return new int[2];
    }

}

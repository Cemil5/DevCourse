package DataStructure.Canvas_Q_A;

import java.util.Arrays;

/*
Two Sum
Problem Definition:
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use
the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
 */

public class Array_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 5, 11, 15}, 9)));
    }


    public static int[] twoSum(int[] arr, int target){
        for (int i=0; i<arr.length-1; i++){
            for (int j=i+1; j<arr.length; j++){
                if (arr[i]+arr[j] == target){
                    return new int[]{ i, j};
                }
            }
        }
        return new int[]{ -1, -1};
    }

    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}

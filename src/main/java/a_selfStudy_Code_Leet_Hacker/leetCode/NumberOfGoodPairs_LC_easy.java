package a_selfStudy_Code_Leet_Hacker.leetCode;
/*
1512. Number of Good Pairs
leetcode Easy
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.

Example 3:

Input: nums = [1,2,3]
Output: 0

 */

public class NumberOfGoodPairs_LC_easy {
    public static int numIdenticalPairs1(int[] nums) {
        int count =0;
     //   String str = "";
        for (int i=0; i<nums.length; i++){
       //     if (!str.contains(nums[i]+"")){
       //         str += nums[i] + ",";
                for (int j=i+1; j<nums.length;j++){
                    if (nums[i]==nums[j]){
                        count++;
                    }
                }
         //   }
        }
        return count;
    }

    public static int numIdenticalPairs(int[] nums) {
        int count =0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length;j++){
                if (nums[i]==nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        System.out.println(numIdenticalPairs(new int[]{1,1,1,1}));
    }

}

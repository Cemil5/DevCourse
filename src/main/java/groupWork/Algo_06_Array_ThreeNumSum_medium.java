package groupWork;

import java.util.*;
import java.util.stream.Collectors;

/*  Question # 6
Difficulty: Medium
Write a function that takes in a non-empty array of distinct integers and an integer
representing a target sum. The function should find all triplets in the array that sum up to
the target sum and return a two-dimensional array of all these triplets. The numbers in each
triplet should be ordered in ascending order, and the triplets themselves should be ordered
in ascending order with respect to the numbers they hold. If no three numbers sum up to
the target sum, the function should return an empty array.
Sample Input
array = [12, 3, 1, 2, -6, 5, -8, 6]. targetSum = 0
Sample Output
[[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]

 */
public class Algo_06_Array_ThreeNumSum_medium {
    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        System.out.println(threeSum(array, targetSum));
        System.out.println(threeSumSet(array, targetSum));
      //  System.out.println(threeNumberSum(array, targetSum));

        List<Integer[]> res = threeNumberSum(array, targetSum);
        StringBuilder str = new StringBuilder();
        for (Integer[] arr : res){
            str.append(Arrays.toString(arr)).append(", ");
        }
        System.out.println("Group " + str);

        Set<Integer[]> res1 = threeNumSumWhile(array, targetSum);
        StringBuilder str1 = new StringBuilder();
        for (Integer[] arr : res1){
            str1.append(Arrays.toString(arr)).append(", ");
        }
        System.out.println("Mine " + str1);
    }

    // my solution While
    public static Set<Integer[]> threeNumSumWhile(int[] array, int targetSum) {
        Arrays.sort(array);
        Set<Integer[]> result = new LinkedHashSet<>();
        for (int i = 0; i < array.length - 2 && array[i]<targetSum; i++) {
            int j = i;
            while (j < array.length - 2 ) {
                int k = array.length - 1;
                int currentSum = array[i] + array[j] + array[k];
                while (currentSum > targetSum && k > j) {
                    k--;
                    currentSum = array[i] + array[j] + array[k];
                }
                if (currentSum == targetSum) {
                   result.add(new Integer[]{array[i], array[j], array[k]});
                }
                j++;
            }
        }
        return result;
    }

    // my solution set
    public static Set<Integer[]> threeNumSumSet(int[] array, int targetSum) {
        Arrays.sort(array);
        Set<Integer[]> result = new LinkedHashSet<>();
        for (int i = 0; i< array.length-2; i++) {
            for (int j = i+1; j<array.length-1; j++) {
                for (int k = j+1; k< array.length; k++) {
                    if (array[i] + array[j] + array[k] == targetSum) {
                       // var temp = Arrays.stream(new int[]{a1, a2, a3}).sorted().toArray();
                        var temp = new Integer[]{array[i], array[j], array[k]};
                        result.add(temp); // if (!result.contains(temp))
                        break;
                    } else if (array[i] + array[j] + array[k] > targetSum) break;
                }
            }
        }
        return result;
    }

    // my solution set
    public static Set<List<Integer>> threeSumSet(int[] array, int targetSum) {
        Set<List<Integer>> result = new HashSet<>();
        for (int a1 : array) {
            for (int a2 : array) {
                for (int a3 : array) {
                    if (a1 + a2 + a3 == targetSum) {
                        var temp = new ArrayList<Integer>(Arrays.asList(a1, a2, a3)).stream().sorted().collect(Collectors.toList());
                         result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    // my solution list
    public static List<List<Integer>> threeSum(int[] array, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        for (int a1 : array) {
            for (int a2 : array) {
                for (int a3 : array) {
                    if (a1 + a2 + a3 == targetSum) {
                        var temp = new ArrayList<Integer>(Arrays.asList(a1, a2, a3)).stream().sorted().collect(Collectors.toList());
                        if (!result.contains(temp)) result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    // O(n^2) time | O(n) space
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum){   // best solution for me
        Arrays.sort(array);// nlog n
        List<Integer[]> triplets = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int left = i +1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    Integer[] newTriplet = {array[i], array[left], array[right]};
                    triplets.add(newTriplet);
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    public static List<Integer[]> withJoker(int[] nums, int targetSum) {
        int i = 0, j = nums.length - 1, joker = 1;
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(nums);
        while (i < j) {
            while (joker < j) {
                if (nums[i] + nums[j] + nums[joker] == targetSum) {
                    Integer[] triplet = {nums[i], nums[joker], nums[j]};
                    result.add(triplet);
                    joker++;
                    j--;
                } else if (nums[i] + nums[j] + nums[joker] < targetSum) {
                    joker++;
                } else {
                    j--;
                }
            }
            i++;
            j = nums.length - 1;
            joker = i + 1;
        }
        return result;
    }
}

package groupWork;

/*
Input : arr[] = {1, 3, 2, 1, 4, 1}
Output : 1
1 appears three times in array which
is maximum frequency.

Input : arr[] = {10, 20, 10, 20, 30, 20, 20}
Output : 20
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Udemy_most_freq_element {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 4, 1};
        System.out.println(Arrays.toString(getMostFreq(nums)));

    }
    // my solution
    // complexity : O(n)
    static int[] getMostFreq(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = {nums[0], 1};
        int temp;
        for (int num : nums) {
            if (map.containsKey(num)) {
                temp = map.get(num) + 1;
                if (temp > max[1]){
                    max[0] = num;
                    max[1] = temp;
                }
                map.put(num, temp);
            } else
                map.put(num, 1);
        }
        return max;
    }

    // geeksforgeeks solution
    // complexity : O(n log(n))
    static int mostFrequent(int arr[]){
        int n = arr.length;
        // Sort the array
        Arrays.sort(arr);

        // find the max frequency using linear
        // traversal
        int max_count = 1, res = arr[0];
        int curr_count = 1;

        for (int i = 1; i < n; i++)
        {
            if (arr[i] == arr[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = arr[i - 1];
                }
                curr_count = 1;
            }
        }

        // If last element is most frequent
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = arr[n - 1];
        }

        return res;
    }
}

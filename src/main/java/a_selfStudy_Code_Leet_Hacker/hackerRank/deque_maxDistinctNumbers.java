package a_selfStudy_Code_Leet_Hacker.hackerRank;

import java.util.*;

/*
in this problem, you are given N integers. You need to find the maximum number of unique integers among all the
possible contiguous subarrays of size M.
Note: Time limit is 3 second for this problem.
Input Format
The first line of input contains two integers N and M: representing the total number of integers and the size of
the subarray, respectively. The next line contains N space separated integers.
Constraints
1 <= N <= 100000
1 <= M <= 100000
The numbers in the array will range between [0, 10000000]

Output Format
Print the maximum number of unique integers among all possible contiguous subarrays of size M.

Sample Input
63
535232
Sample Output
3
Explanation
in the sample testcase, there are 4 subarrays of contiguous numbers.
S1 = (5, 3, 5) - Has 2 unique numbers.
S2 = (3, 5, 2) - Has 3 unique numbers.
S3 = (5, 2, 3) - Has 3 unique numbers.
S4 = (2, 3, 2) - Has 2 unique numbers.
in these subarrays, there are 2, 3, 3, 2 unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is 3.
 */
public class deque_maxDistinctNumbers {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = 6;
        int m = 3;
        int max = Integer.MIN_VALUE;
        int[] allNumbers = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int input = random.nextInt(3);
            allNumbers[i] = input;
            deque.add(input);
            set.add(input);

            if (deque.size() == m) {
                System.out.println("deque = " + deque);
                System.out.println("set = " + set);
                if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (!deque.contains(first)) set.remove(first);
            }
        }
        System.out.println("Arrays.toString(allNumbers) = " + Arrays.toString(allNumbers));
        System.out.println(max);



    }
}

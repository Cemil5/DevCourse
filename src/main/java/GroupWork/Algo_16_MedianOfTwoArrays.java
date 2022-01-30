package GroupWork;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
Question # 16
Description:
Median of Two Sorted Arrays
Difficulty: Hard Category: Array
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median
of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:
Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:
Input: nums1 = [2], nums2 = []
Output: 2.00000
*/
/*
https://www.youtube.com/watch?v=NTop3VTjmxk

 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4

 If we combine these 2 arrays, then median divide the array into 2 parts: left and right whose length are the "same". The left part consists of part of nums1 + part of nums2, so we can divide both nums1 and nums2 to 2 smaller parts and it can be the whole big picture.

Magic hidden in the solution is: Where to put the median number if the total length is odd, left_part or right_part?
Answer: we put the median of odd number of elements to the left part., that's the reason why j = (m + n + 1)/2 - i can work.
It comes to the most difficult part: odd/even, I want to give some complementary explanation:
Note the presumption in the OP:
1.1 If m + n is even, then split the elements evenly into the left and right part, so i + j = m + n - i - j. (Clearly the 1st middle number is in the left part and the 2nd middle number is in the right part) => thus j = (m + n)/2 - i (1)
1.2 If m + n is odd, then put the median in the left part, so the number of elements in the left part is one more than that of elements in the right part. That's where + 1 comes in the formula: i + j = m + n - i - j + 1 => thus j = (m + n + 1)/2 - i(2)

Then!!! (1) can be merged to (2)! How? Let's list them together:

(1) j = (m + n)/2 - i, if m + n is even
(2) j = (m + n + 1)/2 - i, if m + n is odd

Notice that if a number num is even, then num/2 = (num + 1)/2, for example 4/2 = (4 + 1)/2 = 2. So (m + n)/2 is equal to (m + n + 1)/2 in (1). Thus we can merge them to (2). That's the reason why we use j = (m + n + 1)/2 - i through our code.

Another implicit point in the binary search induction rule: 0 <= j <= n (it is thought as right by default, but it is not until m < n), let me prove.
Normally we don't wanna IndexOutOfBound, so the complete version should be:

 if(i - 1 >= 0 && i - 1 < m && j >= 0 && j < n && nums1[i - 1] > nums2[j]) right = i - 1;
 else if(j - 1 >= 0 && j - 1 < n && i >= 0 && i < m && nums2[j - 1] > nums1[i]) left = i + 1;

But since the imin starts with 0 and imax starts with m, so it is guaranteed that: 0 <= i <= m(1)
And j = (m + n + 1)/2 - i, since 0 <= i <= m, (m + n + 1)/2 - m <= j <= (m + n + 1)/2 which can be simplified to (n - m + 1)/2 <= j <= (m + n + 1)/2:
For the left side: (n - m + 1)/2 <= j => n - m >= 0(since we make sure that m <= n by switching nums1 and nums2) => (n - m + 1)/2 >= 1/2 = 0 => so j >= 0(2.1)
For the right side: j <= (m + n + 1)/2 => m <= n => so we have j <= (2n + 1)/2 => and 2n + 1 must be odd, so (2n + 1)/2 = 2n/2 = n => thus j <= n(2.2)
So 0 <= j <= n is an implicit condition(2).

With (1) and (2):

 if(i - 1 >= 0 && i - 1 < m && j >= 0 && j < n && nums1[i - 1] > nums2[j]) right = i - 1;
        else if(j - 1 >= 0 && j - 1 < n && i >= 0 && i < m && nums2[j - 1] > nums1[i]) left = i + 1;

        Then condition I commented is right by default, so no need to write them. Also
        For if statement, since the relation j = (m + n + 1)/2 - i, if i >= 1, then upper bound of j is decreased by 1, i.e. j <= n becomes j < n, so j < n is right by default, no need to write or we can just keep one of them.
        For else statement, the same reason, j - 1 >= 0 and i < m are right dependently, we can just keep one of them.
        Above, the code can be simplified to(one kind of the final versions):

        if(i - 1 >= 0 &&  i - 1 < m && j >= 0 && j < n &&  nums1[i - 1] > nums2[j]) right = i - 1;
        else if(j - 1 >= 0 && /* j - 1 < n && i >= 0 && i < m && nums2[j - 1] > nums1[i]) left = i + 1;
 */
public class Algo_16_MedianOfTwoArrays {

    @DataProvider(name = "inputArrays")
    public Object[][] getInputArrays(){
        return new Object[][]{   //   1, 2, 3, 4, 5, 8
                {new int[]{1, 4, 5, 8},   new int[]{2, 3},      3.5},
                {new int[]{1, 2},       new int[]{3, 4},        2.5},
                {new int[]{0, 0},       new int[]{0,0},         0},
                {new int[]{},           new int[]{1},           1},
                {new int[]{2},          new int[]{},            2},
                {new int[]{1, 7},       new int[]{2, 4},        3},
                {new int[]{3,6},        new int[]{18, 19, 28, 29, 38, 39, 100},     28},
                {new int[]{0, 7},       new int[]{1, 18, 19, 28, 29, 38, 39, 100},  (19+28)/(double) 2}
        };
    }

    @Test(dataProvider = "inputArrays")
    public void test(int[] nums1, int[] nums2, double expectedResult){
        Assert.assertEquals(findMedianSortedArrays(nums1, nums2), expectedResult);
        Arrays.binarySearch(nums1, 3);
    }

    // https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
    public double findMedianSortedArrays(int[] input1, int[] input2) {
        //if input1 length is greater than input2, switch them so that input1 is smaller than input2.
        if (input1.length > input2.length)
            return findMedianSortedArrays(input2, input1);
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) >>> 1;    // means = (low + high)/2;
            /*
 The >>> operator is the unsigned right bit-shift operator in Java. It effectively divides the operand by 2 to the power
 of the right operand, or just 2 here. The difference between >> and >>> would only show up when shifting negative numbers.
 The >> operator shifts a 1 bit into the most significant bit if it was a 1, and the >>> shifts in a 0 regardless.
             */
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX  = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY  = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }
        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }




    public static double findMedianOfTwoSortedArrays(int[] arr1, int[] arr2) {
        if(arr1.length>arr2.length){
            return findMedianOfTwoSortedArrays(arr2,arr1);
        }
        int low = 0;
        int high = arr1.length;
        int lengthArr1 = arr1.length;
        int lengthArr2 = arr2.length;

        while (low <= high){
            int partArr1 = (low + high) / 2;
            // +1 bcz, if its even suppose n1 = 4, n2 = 6 then cut2 will be 5
            // and if its odd suppose, n1 = 3, n2 = 4 then cut2 will be 4, bcz we need +1 of mid, that's why
            int partArr2 = (lengthArr1 + lengthArr2+1) / 2 - partArr1;
            int maxOfleftArr1;
            int minOfRightArr1;
            int maxOfleftArr2;
            int minOfRightArr2;
            if (partArr1 == 0)  maxOfleftArr1 = Integer.MIN_VALUE;
            else  maxOfleftArr1 = arr1[partArr1-1];

            if (partArr1 == arr1.length) minOfRightArr1 = Integer.MAX_VALUE;
            else minOfRightArr1 = arr1[partArr1];

            if (partArr2 == 0)  maxOfleftArr2 = Integer.MIN_VALUE;
            else  maxOfleftArr2 = arr2[partArr2-1];

            if (partArr2 == arr2.length) minOfRightArr2 = Integer.MAX_VALUE;
            else minOfRightArr2 = arr2[partArr2];

            if (maxOfleftArr1 <= minOfRightArr2 && maxOfleftArr2 <= minOfRightArr1) {
                if((lengthArr1 + lengthArr2) % 2 == 0){
                    return((double) (Math.max(maxOfleftArr1,maxOfleftArr2)+Math.min(minOfRightArr1,minOfRightArr2))/2);
                } else
                    return ((double) Math.max(maxOfleftArr1,maxOfleftArr2));
            } else if (maxOfleftArr1>minOfRightArr2) {high=partArr1-1;}
            else {
                low=partArr1+1;
            }
        }
        return -1;
    }


}

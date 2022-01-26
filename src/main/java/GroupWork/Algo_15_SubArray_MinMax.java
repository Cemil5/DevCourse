package GroupWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Algo_15_SubArray_MinMax {
    @DataProvider(name = "inputArrays")
    public Object[][] getInputArrays(){
        return new Object[][]{
                {new int[]{3,9},new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}},
                {new int[]{1,5}, new int[]{2,6,4,8,10,9,15}},
                {new int[]{1,3}, new int[]{2,6,4,5}},
                {new int[]{-1,-1}, new int[]{8, 9, 10}},
                {new int[]{0,1}, new int[]{18, 9}},
                {new int[]{3,6}, new int[]{18, 19, 28, 100, 29, 38, 39,}},
                {new int[]{0, 7}, new int[]{200, 18, 19, 28, 100, 29, 38, 39}}
        };
    }

    @Test(dataProvider = "inputArrays")
    public void testAlgo15MySol1(int[] expectedResult, int[] inputArray){
      //  Assert.assertEquals(expectedResult, Algo15_subArraySort.getUnsortedSubArrayMySol1(inputArray));
    }

    // O(n) time | O(1) space
    public static int[] subarraySort(int[] array) {
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, num);
                maxOutOfOrder = Math.max(maxOutOfOrder, num);
            }
        }
        if (minOutOfOrder == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }
        int subarrayLeftIdx = 0;
        while (minOutOfOrder >= array[subarrayLeftIdx]) {
            subarrayLeftIdx++;
        }
        int subarrayRightIdx = array.length - 1;
        while (maxOutOfOrder <= array[subarrayRightIdx]) {
            subarrayRightIdx--;
        }
        return new int[] {subarrayLeftIdx, subarrayRightIdx};
    }
    public static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        }
        if (i == array.length - 1) {
            return num < array[i - 1];
        }
        return num > array[i + 1] || num < array[i - 1];
    }


    static int[] findTheUnsortedPart(int[] arr){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] result = {-1,-1};

        for(int i = 0;i< arr.length;i++){
            int j = arr.length-1-i;

            if(i != arr.length-1 && arr[i+1]<arr[i]) max = Math.max(arr[i],max );
            if(j != 0 && arr[j-1]>arr[j]) min = Math.min(arr[j],min);

            if( arr[i]<=max) result[1] = i;
            if( arr[j]>=min) result[0] = j;
        }
        return result;
    }

    static int[] findTheUnsortedPart2(int[] arr){
        int i = 0,j = arr.length-1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] result = {-1,-1};

        while(i< arr.length){

            if(i != arr.length-1 && arr[i+1]<arr[i]) max = Math.max(arr[i],max );
            if(j != 0 && arr[j-1]>arr[j]) min = Math.min(arr[j],min);

            if( arr[i++]<=max) result[1] = i-1;
            if( arr[j--]>=min) result[0] = j+1;
        }
        return result;
    }

    static int[] findTheUnsortedPartWithSort(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        int[] result = {-1, -1};
        int left = -1, right = arr.length;
        Arrays.sort(sorted);

        for (int i = 0; i < arr.length; i++) {

            int j = arr.length - 1 - i;
            if (left == -1 && sorted[i] != arr[i]) result[0] = left = i;
            if (right == arr.length && sorted[j] != arr[j]) result[1] = right = j;
        }

        return result;
    }
    public static int[] bruteForce(int[] nums) {

        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int[] compare = Arrays.copyOf(nums, nums.length);
        int startPoint = -1;
        int endPoint = -1;

        Arrays.sort(nums);

        if (compare[0] != nums[0]) {
            startPoint = 0;
        }

        if (compare[compare.length - 1] != nums[nums.length - 1]) {
            endPoint = compare.length - 1;
        }

        for (int i = 1, j = nums.length - 1; i <= j; i++, j--) {

            if (compare[i] != nums[i] && startPoint == -1) {
                startPoint = i;
                i--;
            }

            if (compare[j] != nums[j] && endPoint == -1) {
                endPoint = j;
                j++;
            }

        }

        return new int[] {startPoint, endPoint};

    }

    public static int[] subArraySort(int[] nums) {

        int start = -1;
        int end = -1;
        int max = 0;
        int min = 0;

        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        for (int i =  0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }

        if (start == - 1) {
            return new int[] {-1, -1};
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                end = i;
                break;
            }
        }

        max = nums[start];
        min = nums[start];

        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        for (int i = 0; i < start; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= end; i--) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }

        return new int[] {start, end};

    }
}

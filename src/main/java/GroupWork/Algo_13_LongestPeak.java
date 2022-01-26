package GroupWork;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Question #13
Longest Peak
Difficulty : Medium. Category : Arrays
Write a function that takes in an array of integers and returns the length of the longest peak
in the array. A peak is defined as adjacent integers in the array that are strictly increasing
until they reach a tip (the highest value in the peak), at which point they become strictly
decreasing. At least three integers are required to form a peak. For example, the integers 1,
4, 10, 2 form a peak, but the integers 4, 0, 10 don't and neither do the integers 1, 2, 2, 0 .
Similarly, the integers 1, 2, 3 don't form a peak because there aren't any strictly decreasing
integers after the 3.
Sample Input
array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
Sample Output
6 // 0, 10, 6, 5, -1, -3
 */
public class Algo_13_LongestPeak {

    @DataProvider(name = "input")
    public Object[][] inputMethod(){
        return new Object[][]{
                {new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}, 6},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10}, 0},
                {new int[]{1, 2, 3}, 0},
                {new int[]{3, 3, 3}, 0},
                {new int[]{-3, -13, -23}, 0},
                {new int[]{-3, 3, 1, 2, 3 , -10, -18, 7}, 5},
                {new int[]{1, 2, 3, 5, 3, 7, 15, 2, 16, 3, 0}, 5},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 0},
                {new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 0},
                {new int[]{1, 2, 3, 4, 4, 7, 7, 2, 1, 0, 0}, 0},
                {new int[]{1, 2, 1}, 3},
                {new int[]{0}, 0},
        };
    }
    @Test(dataProvider = "input")
    public void test1(int[] input, int expected){
        Assert.assertEquals(myLongestPeak(input), expected);
        Assert.assertEquals(longestPeak(input), expected);
    }

    // my solution
    public static int myLongestPeak(int[] array) {
        List<Integer> currentPeak = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean asc = false;
        boolean des = false;
        for (int i = 0; i < array.length; i++) {
            if (currentPeak.size() == 0) {
                currentPeak.add(array[i]);
            }
            else {
                if (array[i] > currentPeak.get(currentPeak.size() - 1) && !des) {
                    currentPeak.add(array[i]);
                    asc = true;
                } else if (array[i] < currentPeak.get(currentPeak.size() - 1) && asc) {
                    currentPeak.add(array[i]);
                    des = true;
                } else {
                    if (currentPeak.size() > result.size() && asc && des) result = List.copyOf(currentPeak);
                    currentPeak.clear();
                    asc = false;
                    des = false;
                    while (array[i] > array[i-1] && i > 1) {
                        i--;
                    }
                    if ( array[i] <= array[i-1] ) i--;
                }
            }
        }
        if (currentPeak.size() > result.size() && asc && des) result = List.copyOf(currentPeak);
        return result.size();
    }


    public static int longestPeak(int[] array) {        // best solution for me
        int longestPeakLength = 0;
        int i = 1;
        while (i < array.length - 1) {
            boolean peak = array[i - 1] < array[i] && array[i] > array[i + 1];
            if (!peak) {
                i += 1;
                continue;
            }
            int leftIdx = i - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx -= 1;
            }
            int rightIdx = i + 2;
            while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx += 1;
            }
            int currentPeakLength = rightIdx - leftIdx - 1;
            if (currentPeakLength > longestPeakLength) {
                longestPeakLength = currentPeakLength;
            }
            i = rightIdx;
        }
        return longestPeakLength;
    }

       //*************************************************************
    public static void longestPeak5(int[] arr) {        // very similar to best solution
        int longestLength = 0;
        int i = 1;                      //first element can not be a peak
        while(i < arr.length - 1) {           //last too
            if (arr[i] <= arr[i - 1] || arr[i] <= arr[i + 1]) {
                i += 1;                         // prev<Peak>next
                continue;                       //no peak point (-peak)
            }
            int leftNum = i - 1;
            while (arr[leftNum] < arr[leftNum + 1]) { //to catch starting point
                leftNum --;
            }
            int rightNum = i + 1;
            while(arr[rightNum] < arr[rightNum - 1]) {//to catch end point
                rightNum ++;
            }
            int currLength = rightNum - leftNum - 1;
            if(currLength>=longestLength){
                longestLength=currLength;
            }
            i = rightNum;
        }
        System.out.println( "Longest peak length is: "+longestLength);


    }

//********************************************************************
public static int longestPeak6(int[] array){
    List<Integer> peakElements = new ArrayList<>();
    int i = 0;
    int peak;
    int peakIndex;

    while (i < array.length - 2){
        if (array[i] < array[i + 1] & array[i + 1] > array[i + 2]){     // finds peak index i+1
            peak = array[i + 1];
            peakIndex = i + 1;
            peakElements.add(findPeakNumbers(peakIndex, array));
        }
        i++;
    }
    return Collections.max(peakElements);
}

    public static int findPeakNumbers(int peakIndex, int[] array){
        int j = peakIndex;
        int beginPeak;
        int endPeak;

        while (j > 0){
            if (array[j] > array[j - 1]){
                j--;
            }else break;
        }

        beginPeak = j;
        j= peakIndex;

        while (j < array.length-1){
            if (array[j] > array[j + 1]){
                j++;
            }else break;
        }
        endPeak = j + 1;
        return endPeak - beginPeak;
    }

//*****************************************************************
static int findTheLongestPeak(int[] arr) {
    int lb = 0, ub = 0, peak = 0, distance = 0;

    while (ub < arr.length) {

        if (ub == arr.length - 1) {
            if (ub != peak) distance = Math.max(distance, ub - lb + 1);
            break;
        }
        if (arr[ub + 1] > arr[ub]) {
            if (ub != peak) {
                distance = Math.max(distance, ub - lb + 1);
                peak = lb = ub;
            } else peak = ++ub;

        } else if (arr[ub + 1] < arr[ub]) {
            if (ub != lb) ub++;
            else peak = lb = ++ub;

        } else {
            if (ub != peak) distance = Math.max(distance, ub - lb + 1);
            peak = lb = ++ub;
        }
    }
    return distance;
}

    //******************************************
    public static List<Integer> longestPeak3(int[] nums) {

        List<Integer> longestPeak = new ArrayList<>();
        int longestLength = 0;

        for (int i = 1; i < nums.length - 1; i++) {

            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {

                int left = i - 1;
                int right = i + 1;
                int peakPoint = i;
                int beginning = left;
                int ending = right;

                List<Integer> leftList = new ArrayList<>();
                List<Integer> rightList = new ArrayList<>();

                leftList.add(nums[i]);

                while (left >= 0 && nums[left] < nums[left + 1]) {
                    beginning = left;
                    leftList.add(nums[left]);
                    left--;
                }

                while (right <= nums.length - 1 && nums[right - 1] > nums[right]) {
                    ending = right;
                    rightList.add(nums[right]);
                    right++;
                }

                int listLength = (nums[peakPoint] - nums[beginning]) + (nums[peakPoint] - nums[ending]);

                if (longestPeak.size() == 0 || listLength > longestLength) {
                    longestPeak = new ArrayList<>();
                    for (int l = leftList.size() - 1; l >= 0; l--) {
                        longestPeak.add(leftList.get(l));
                    }
                    for (int r = 0; r < rightList.size(); r++) {
                        longestPeak.add(rightList.get(r));
                    }

                    longestLength = listLength;

                }

                i = right - 1;

            }

        }

        return longestPeak;

    }
    //**********************************************************
    public static ArrayList<Integer> longestPeak4(int[] arr) {      // similar to my solution
        boolean increasing = false;
        boolean decreasing = false;
        ArrayList<Integer> peak = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            peak.add(arr[i]);
            while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
                increasing = true;
                peak.add(arr[i + 1]);
                i++;
            }
            while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                decreasing = true;
                peak.add(arr[i + 1]);
                i++;
            }
            if (increasing && decreasing) {
                if (peak.size() > result.size()) {
                    result = (ArrayList<Integer>) peak.clone();
                }
                i--;
            }
            peak.clear();
            increasing = false;
            decreasing = false;
        }
        return result;
    }

    //************************************************
    public static int longestPeakFinder(int[] array) {      // similar to best solution
        // Using two pointers left and right // Move towards right
        int n = array.length;
        int left = 0;         int right;         int max = 0;
        // Needs at least 3 array elements to form a peak
        if (n < 3) return 0;
        while (left < n - 2) {
            //skip descending and equal array
            while (left < n - 1 && array[left] >= array[left + 1]) {
                System.out.println("not uphill so skip element = " + array[left]);
                left++;
            }
            right = left + 1;
            //GOING UP UPHILL to form a peak: right element must be smaller than adjacent
            while (right < n - 1 && array[right] < array[right + 1]) {
                System.out.println("going uphill  = " + array[right]);
                right++;
            }
            //GOING DOWNHILL to form a descend
            while (right < n - 1 && array[right] > array[right + 1]) {
                System.out.println("going downhill  = " + array[right]);
                right++;
                max = Math.max(max, right - left + 1);                //update the max value
                System.out.println("max = " + max);
            }
            left = right;
        }
        return max;
    }



    // with Peak class
    private static int mySol1(int[] array){
        ArrayList<Peak> peaks = new ArrayList<>();
        peaks.add(new Peak(array[0]));

        for (int i = 1; i < array.length; i++) {
            Peak lastPeek = peaks.get(peaks.size() - 1);
            int currentArrayElement = array[i];
            if (lastPeek.isClimbing != null && lastPeek.isClimbing){
                if (currentArrayElement == lastPeek.last)
                    peaks.add(new Peak(currentArrayElement));
                else
                    lastPeek.addNewPoint(currentArrayElement);
            }
            else {
                if (currentArrayElement < lastPeek.last)
                    lastPeek.addNewPoint(currentArrayElement);
                else if (currentArrayElement > lastPeek.last)
                {
                    Peak newPeek = new Peak(lastPeek.last);
                    newPeek.addNewPoint(currentArrayElement);
                    peaks.add(newPeek);
                }
            }
        }
        peaks.removeIf(p -> !p.isPeak);
        peaks.sort((o1, o2) -> o2.length > o1.length ? 1 : -1);
        return peaks.size() == 0 ? 0 : peaks.get(0).length;
    }
}

class Peak{
    int last, length = 1;
    Boolean isClimbing = null;
    boolean isPeak;
    public Peak(int start){
        last = start;
    }
    public void addNewPoint(int newPoint){
        boolean isClimbingTemp = newPoint > last;
        if (length == 1)
            isClimbing = isClimbingTemp;
        else {
            if (!isPeak)
                isPeak = isClimbing != isClimbingTemp;

            isClimbing = isClimbingTemp;
        }

        last = newPoint;
        length++;
    }
}
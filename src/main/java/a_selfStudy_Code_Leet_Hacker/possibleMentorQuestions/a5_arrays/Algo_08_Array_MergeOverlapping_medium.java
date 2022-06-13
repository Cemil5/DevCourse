package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a5_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
Question # 8
Merge Overlapping Intervals
Difficulty: Medium Category: Array
Write a function that takes in a non-empty array of arbitrary intervals, merges any
overlapping intervals, and returns the new intervals in no particular order. Each interval is an
array of two integers, with interval[0] as the start of the interval and interval[1] as the end of
the interval. Note that back-to-back intervals aren't considered to be overlapping. For
example, [1, 5] and [6, 7] aren't overlapping; however, [1, 6] and [6, 7] are indeed
overlapping. Also note that the start of any particular interval will always be less than or
equal to the end of that interval.
Sample Input
intervals = [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]
Sample Output
[[1, 2], [3, 8], [9, 10]] //
Merge the intervals [3, 5], [4, 7], and [6, 8]. // The intervals could be ordered differently
 */
public class Algo_08_Array_MergeOverlapping_medium {

    public static void main(String[] args) {
        int[][] input = {{1,2}, {3,5}, {4,7}, {6,8}, {9,10}};
        System.out.println(merge(input));
        System.out.println(mergeOverlappingIntervals(input));

        System.out.println(Arrays.deepToString(mergeOverlapping(input)));
    }


    static List<List<Integer>> merge(int[][] arr){
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));   // nlogn
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i< arr.length;i++){    //n
            if( i != arr.length-1 && arr[i][1]>=arr[i+1][0] ){
                arr[i+1][0] = arr[i][0];
                arr[i+1][1] = Math.max(arr[i][1],arr[i+1][1]);
            } else list.add(Arrays.asList(arr[i][0],arr[i][1]));
        }
        return list;
    }

    public static int[][] mergeOverlapping(int[][] firstArray){     // edge case lerde problemli...
        int[] flatArray = Arrays.stream(firstArray)
                .flatMapToInt(Arrays::stream)
                .toArray();
        System.out.println(Arrays.toString(flatArray));

        int[] removedOverlap = new int[flatArray.length];
        int i = 0;int j = 0;
        do {
            removedOverlap[i++] = flatArray[j++];
            if (j == flatArray.length - 2) {
                removedOverlap[i++] = flatArray[j++];
                removedOverlap[i] = flatArray[j];
                break;
            }
            while (flatArray[j] > flatArray[j + 1]){
                j+=2;
            }
        } while (j < flatArray.length - 2);


        int[][] newArray = new int[firstArray.length][2];
        int count = 0;
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 2; y++){
                newArray[x][y] = removedOverlap[count++];
            }
        }
        return newArray;
    }

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : 0));
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();             //Temp for holding overlapping intervals
        for (int i = 0; i < intervals.length - 1; i++) {
            //checks whether last element and first element of the intervals overlapping or not
            if (intervals[i][1] >= intervals[i + 1][0]) {
                if (temp.size() == 0) {                     //0 means last intervals was not overlapping
                    temp.addAll(Arrays.asList(intervals[i][0], intervals[i + 1][1]));
                } else {
                    temp.set(1, intervals[i + 1][1]);       //if last intervals was already overlapping, just extend the interval
                }
            } else {                                        //not overlapping.
                if (temp.size() != 0) {
                    result.add(temp);                        //add temp into the result
                    temp = new ArrayList<>();
                    continue;                                  //If we don't use continue, last interval of temp separately added into result
                }
                result.add(Arrays.asList(intervals[i][0], intervals[i][1]));    //Un-overlapping interval added into result
            }
        }
        if (result.get(result.size() - 1).get(1) < intervals[intervals.length - 1][0]) {                                //If last interval is not overlapping, add it into result.
            result.add(Arrays.asList(intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]));
        }
        return result;
    }

    public static List<int[]> mergeOverlappingIntervals2(int[][] input){

        Arrays.sort(input, Comparator.comparingInt(o -> o[0]));
        List<int[]> output = new ArrayList<>();

        int current = 0;
        int next = current + 1;
        int tempMin = input[current][0];
        int tempMax = input[current][1];

        while(current < input.length-1) {
            if((tempMax < input[next][0]) && (tempMax < input[next][1]) && (tempMin < input[next][0])){
                addInterval(output, tempMin, tempMax);
                current++;
                next++;
                tempMin = input[current][0];
                tempMax = input[current][1];
            }else{
                current++;
                next++;
                tempMin = Math.min(tempMin, input[current][0]);
                tempMax = Math.max(tempMax, input[current][1]);
            }
        }
        addInterval(output, tempMin, tempMax);
        return output;
    }
    public static void addInterval(List<int[]> output, int element1, int element2){
        int[]newInterval = new int[]{element1, element2};
        output.add(newInterval);
    }



}

package batch2_Questions;

/*
Java Developer Alumni Batch 2 Algo Question
Assignment 5
Description:  Buildings with sunset view
Difficulty: Easy Category: stack
Given an array of buildings and a direction that all the buildings face, return an array of
the indices of the buildings that can see the sunset. A building can see the sunset if it's
strictly taller than all the buildings that come after it in the direction that it faces. The
input array named buildings contains positive, non-zero integers representing the heights of
the buildings. A building at index i thus has a height denoted by buildings[i] . All the
buildings face the same direction, and this direction is either east or west, denoted by the
input string named direction , which will always be equal to either "EAST" or "WEST" . In
relation to the input array, you can interpret these directions as right for east and left for
west. Important note: the indices in the output array should be sorted in ascending order.
Sample Input #1 buildings = [3, 5, 4, 4, 3, 1, 3, 2] direction = "EAST"
Sample Output #1 [1, 3, 6, 7] //
Sample Input #2 buildings = [3, 5, 4, 4, 3, 1, 3, 2] direction = "WEST"
Sample Output #2 [0, 1]
 // The buildings are the same as in the first sample // input, but their direction is reversed.
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class Stack_SunSet1 {

    @DataProvider
    public Object[][] input(){
        return new Object[][]{
                {new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST", new Integer[]{1, 3, 6, 7} },
                {new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "WEST", new Integer[]{0, 1} },
        };
    }

    @Test(dataProvider = "input")
    public void test(int[] buildings, String direction, Integer[] expected){
        Assert.assertEquals(sunsetViews(buildings, direction), List.of(expected));
    }

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        Deque<Integer> stack = new LinkedList<>();
        ArrayList<Integer> list;

        switch (direction.toUpperCase(Locale.ROOT)){
            case "WEST" :
                stack.push(0);
                for (int i = 1; i < buildings.length; i++) {
                    if(buildings[i] > buildings[stack.peek()]){
                        stack.push(i);
                    }
                }
                break;
            case "EAST" :
                int last = buildings.length-1;
                stack.push(last);
                for (int i = last-1; i > 0; i--) {
                    if(buildings[i] > buildings[stack.peek()]){
                        stack.push(i);
                    }
                }
                break;
        }
        list = new ArrayList<>(stack);
        Collections.sort(list);
        return list;
    }

    public static Deque<Integer> findLuckyOnes2(int[] buildings, String sunsetDirection){
        int max = 0;
        int step = sunsetDirection.equalsIgnoreCase("west") ? 1 : -1;
        int index = sunsetDirection.equalsIgnoreCase("west") ? 0 : buildings.length-1;
        Deque<Integer> result = new ArrayDeque<>();

        while(index >= 0 && index < buildings.length){
            if(buildings[index] > max)
                if(sunsetDirection.equalsIgnoreCase("west")) result.add(index);
                else result.push(index);
            max = Math.max(max,buildings[index]);
            index += step;
        }
        return result;
    }

}

package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a5_arrays;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

import static java.util.Arrays.stream;
import static org.testng.AssertJUnit.assertEquals;

/*
Highest and Lowest Num From String
7 kyu

In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.

Examples
highAndLow("1 2 3 4 5")  // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"
Notes
All numbers are valid Int32, no need to validate them.
There will always be at least one number in the input string.
Output string must be two numbers separated by a single space, and highest number is first.
 */
public class HighestLowestNumFromString_CW_7kyu {

    // my solution
    String highAndLow(String str){
        String[] strings = str.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String s : strings){
            int num = Integer.parseInt(s);
            if (num>max){
                max = num;
            }
            if (num<min){
                min = num;
            }
        }
        return ""+max + " " + min;
    }

    String highAndLow66(String str){
        String[] strings = str.split(" ");
        int[] ints = new int[strings.length];
        for (int i =0;i< ints.length; i++){
            ints[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(ints);
        return ""+ints[ints.length-1] + " " + ints[0];
    }

    public static String highAndLow99(String numbers) {

        String[] numbersString = numbers.split(" ");
        int min=0, max=0, numInt=0;
        boolean firstNo=true;

        for (String n: numbersString){
            numInt=Integer.parseInt(n);
            if (firstNo){
                min=numInt;
                max=numInt;
                firstNo=false;
            } else {
                if (numInt>max){
                    max=numInt;
                } else if (numInt<min){
                    min=numInt;
                }
            }
        }
        return max+" "+min;
    }

    public String highAndLow1(String str) {
        int lastCh = 0;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                set.add(Integer.parseInt(str.substring(lastCh, i)));
                lastCh = i + 1;
            } else if (i == str.length() - 1) {
                set.add(Integer.parseInt(str.substring(lastCh, i + 1)));
            }
        }
        return "" + set.last() + " " + set.first();
    }

    static String highAndLow2(String numbers) {
        var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
    }

    public static String highAndLow3(String numbers) {
        String[] array = numbers.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int value = Integer.parseInt(array[i]);
            if (value < min) min = value;
            if (value > max) max = value;
        }
        return String.format("%d %d", max, min);
    }

    public static String highAndLow4(String numbers) {
        // Code here or
        String[] num = numbers.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : num) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);

        return list.get(list.size() - 1) + " " + list.get(0);
    }

    private static final String SPACE = " ";

    public static String highAndLow5(String numbers) {
        TreeSet<Integer> numberSet = new TreeSet<Integer>();
        String[] numberArr = numbers.split(SPACE);
        for (String numberVal : numberArr) {
            numberSet.add(Integer.parseInt(numberVal));
        }
        return String.valueOf(numberSet.last()) + SPACE + String.valueOf(numberSet.first());

    }

    public static String highAndLow6(String numbers) {
        String[] s = numbers.split(" ");
        int high = Integer.parseInt(s[0]);
        int low = Integer.parseInt(s[0]);

        for (int i = 1; i < s.length; i++) {
            if (Integer.parseInt(s[i]) >= high) {
                high = Integer.parseInt(s[i]);
            }
        }
        for (int j = 1; j < s.length; j++) {
            if (Integer.parseInt(s[j]) <= low) {
                low = Integer.parseInt(s[j]);
            }
        }
        return "" + high + " " + low;
    }

    public static String highAndLow7(String numbers) {
        String[] stringList = numbers.split(" ");

        long mix = -999999999;
        long min = 999999999;

        for(String number : stringList){
            int numberTemp = Integer.parseInt(number);

            if(numberTemp > mix){
                mix = numberTemp;
            }

            if(numberTemp < min){
                min = numberTemp;
            }

        }

        return String.valueOf(mix) + " " + String.valueOf(min);
    }




    @Test
    public void test1() {
        assertEquals("42 -9", highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    @Test
    public void test2() {
        assertEquals("3 1", highAndLow("1 2 3"));
    }
}

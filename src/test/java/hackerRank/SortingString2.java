package hackerRank;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true&utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
/*
We then return the first (lexicographically smallest) substring and the last (lexicographically largest) substring
as two newline-separated values (i.e., ava\nwel).
 */

public class SortingString2 {
    public static void main(String[] args) {
      //  String has the following lexicographically-ordered substrings of length :
        String s = "welcometojava";
        System.out.println(solution(s,3));

    }
    static String solution(String s, int k){
        int a = s.length()-k+1;
        String [] str = new String[a];
        for (int i = 0; i<a; i++){
            str[i] = s.substring(i, i+k);
        }
        System.out.println(Arrays.toString(str));
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));

        return str[0] + "\n" + str[a-1];
    }

    static String solution2(String s, int k){
        String smallest = s.substring(0,k);
        String largest  = "";

        for(int i=0;i<s.length()-k+1;i++){
            String str = s.substring(i, i + k);
            if(str.compareTo(smallest) <0) smallest = str;
            if(str.compareTo(largest) >0) largest = str;
        }
        return smallest + "\n" + largest;
    }
}

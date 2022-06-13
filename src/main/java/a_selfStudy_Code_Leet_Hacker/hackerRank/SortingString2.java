package a_selfStudy_Code_Leet_Hacker.hackerRank;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true&utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
/*
easy
We then return the first (lexicographically smallest) substring and the last (lexicographically largest) substring
as two newline-separated values (i.e., ava\nwel).

---------------------------------------------
We define the following terms:

  ->  Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:
        A < B < ......... < Y < Z < a < b < ... < y < z
        For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.
   -> A substring of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.

Given a string,s, and an integer, k, complete the function so that it finds the lexicographically smallest and largest substrings of length k.

Function Description

Complete the getSmallestAndLargest function in the editor below.

getSmallestAndLargest has the following parameters:

    string s: a string
    int k: the length of the substrings to find

Returns
    string: the string ' + "\n" + ' where and are the two substrings

Input Format :
The first line contains a string denoting.
The second line contains an integer denoting.

Constraints :
    consists of English alphabetic letters only (i.e., [a-zA-Z]).

Sample Input :
welcometojava
3

Sample Output :
ava
wel

Explanation :
String s = "welcometojava"  has the following lexicographically-ordered substrings of length :
[ava, com, elc, eto, jav, lco, met, oja, ome, toj, wel]
We then return the first (lexicographically smallest) substring and the last (lexicographically largest) substring as two newline-separated values (i.e., ava\nwel).

The stub code in the editor then prints ava as our first line of output and wel as our second line of output.
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

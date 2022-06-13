package a_selfStudy_Code_Leet_Hacker.hackerRank;

import java.util.Arrays;
import java.util.Locale;

// https://www.hackerrank.com/challenges/java-strings-introduction/problem

public class SortingString {
    public static void main(String[] args) {
        String A ="java";
        String B ="hello";
        String[] str = {"java", "hello"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));

        System.out.println(A.length()+B.length());
        if (str[0].equals(A))   System.out.println("No");
        else System.out.println("Yes");
        A = A.substring(0, 1).toUpperCase(Locale.ROOT) + A.substring(1) + " " + B.substring(0, 1).toUpperCase(Locale.ROOT) + B.substring(1);

        System.out.println(A);

        System.out.println(A.compareTo(B)>0?"Yes":"No");

    }
}

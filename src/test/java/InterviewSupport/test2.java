package InterviewSupport;

import java.util.Set;
import java.util.TreeSet;

public class test2 {
    public static void main(String[] args) {
        String str1 = "hack";
        String str3 = "hacker";
        String str2 = "hackerrank";

        System.out.println(compare(str1, str2, str3));

    }
    public static String compare(String str1, String str2, String str3){
        String result ="";
        Set<String> set = new TreeSet<>();
        set.add(str1);
        set.add(str2);
        set.add(str3);
        for (String str : set){
            result += str;
        }


        return result;
    }
}

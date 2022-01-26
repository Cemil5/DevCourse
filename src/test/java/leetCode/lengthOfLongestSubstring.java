package leetCode;

import java.util.*;

public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "abcabcbb";    // The answer is "abc", with the length of 3.
        str = "bbbbb";
        str = "pwwkew";
        str = " ";
        str = "au";
        str = "aab";
        str = "ohomm";
        str = "asljlj";


        /*
Given a string s, find the length of the longest substring without repeating characters.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
         */
        System.out.println("lengthOfLongestSubstring(str) = " + lengthOfLongestSubstring(str));
      //  System.out.println(lengthOfLongestSubstringD(str));

    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        String result = "";
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.length() == 1) return 1;
            else if (!result.contains(c + "")) {
                result += c;
                   System.out.println(i +" result :" + result+"'");
                   System.out.println(i + " c =" + c + "'");
                if (i == s.length() - 1 && result.length() == s.length()) return s.length();
            } else {
                int ind = result.indexOf(c);
                map.put(result, result.length());
                System.out.println("i :"+i+" ind = " + ind + " result :"+result);
                if (ind != result.length()) result = result.substring(ind + 1) + c;
                else result = ""+c;
            }
            if (i == s.length() - 1 && !map.containsKey(result)){
                map.put(result, result.length());
            }

        }
        //   System.out.println(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) count = entry.getValue();
        }

        return count;
    }
    public static int lengthOfLongestSubstringD(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int longest = 0;
        int leftPtr = 0;
        int rightPtr = 0;
        char c = ' ';
        int[] map = new int[128];
        Arrays.fill(map, -1); // initialize the map to contain -1 only

        while (rightPtr < n) {
            c = s.charAt(rightPtr);
            leftPtr = Math.max(leftPtr, map[c] + 1); // move leftPtr to the right postion
            longest = Math.max(longest, rightPtr - leftPtr + 1);
            map[c] = rightPtr;
            rightPtr++;
        }

        return longest;
    }
}

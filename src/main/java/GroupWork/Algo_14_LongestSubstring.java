package GroupWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Comparator.comparing;

/*
Question #14
Longest Substring Without Duplication
Difficulty : - Category : Strings
Write a function that takes in a string and returns its longest substring without duplicate characters.
You can assume that there will only be one longest substring without duplication.
Sample Input
string = "clementisacap"
Sample Output
"mentisac"
 */
public class Algo_14_LongestSubstring {
    @DataProvider(name = "input")
    public Object[][] getInputArrays(){
        return new Object[][]{
                {new String[]{"abcabcbb"}, new String[]{"abc"} },
                {new String[]{"bbbbb"}, new String[]{"b"} },
                {new String[]{"pwwkew"}, new String[]{"wke"} },
                {new String[]{" "}, new String[]{" "} },
                {new String[]{"au"}, new String[]{"au"} },
                {new String[]{"aab"}, new String[]{"ab"} },
                {new String[]{"ohomm"}, new String[]{"hom"} },
                {new String[]{"asljlj"}, new String[]{"aslj"} },
                {new String[]{"clementisacap"}, new String[]{"mentisac"} },
                {new String[]{""}, new String[]{""} },
        };
    }
    @Test(dataProvider = "input")
    public void test1(String[] expected, String[] input){
       // Assert.assertEquals(expected,);
    }

    public static void main(String[] args) {
        String str = "abcabcbb";    // The answer is "abc", with the length of 3.
        str = "bbbbb";
        str = "pwwkew";
//        str = " ";
//        str = "au";
//        str = "aab";
//        str = "ohomm";
//        str = "asljlj";
//        str = "clementisacap";
//        str = "";
        System.out.println("lengthOfLongestSubstring(str) = " + myLengthOfLongestSubstring(str));
        System.out.println(bestLongestSubstringWithoutDuplication(str));
    }


    // my solution
    public static String myLengthOfLongestSubstring(String s) {
        if (s.length() == 1) return s;
        int count = 0;
        String substr = "";
        String longest = "";
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!substr.contains(c + "")) {
                substr += c;
                if (i == s.length() - 1 && substr.length() == s.length()) return s;
            } else {
                int ind = substr.indexOf(c);
                map.put(substr, substr.length());
                if (longest.length()<substr.length()) longest = substr;
                if (ind != substr.length()) substr = substr.substring(ind + 1) + c;
                else substr = "" + c;
            }
        }
        if (!map.containsKey(substr)) {     // checks if map contains the substr with last character of s
            map.put(substr, substr.length());
        }
        if (longest.length()<substr.length()) longest = substr;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                substr = entry.getKey();
            }
        }
        return substr;
    }

    public static String bestLongestSubstringWithoutDuplication(String str) {   // best solution for me
        if (str.isEmpty()) return "";
        int longestStart =0;
        int longestEnd =1;
        int currentStartIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.substring(0, i).contains(c+"")) {
                currentStartIdx = Math.max(currentStartIdx, str.substring(0, i).lastIndexOf(c+"") + 1);
            }
            // if you find a longer substring update longest here!!!
            if (longestEnd - longestStart < i + 1 - currentStartIdx) {
                longestEnd = i + 1;
                longestStart = currentStartIdx;
            }
        }
        return str.substring(longestStart, longestEnd);
    }

    // O(n) time | O(min(n, a)) space
    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<Character, Integer>();
        int longestStart =0;
        int longestEnd =1;
        int currentStartIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (lastSeen.containsKey(c)) {
 //               currentStartIdx = Math.max(currentStartIdx, lastSeen.get(c) + 1);
//                System.out.println(currentStartIdx);
                currentStartIdx = Math.max(currentStartIdx, str.substring(0, i).lastIndexOf(c+"") + 1);
//                System.out.println(currentStartIdx);
            }
            // if you find a longer substring update longest here!!!
            if (longestEnd - longestStart < i + 1 - currentStartIdx) {
                longestEnd = i + 1;
                longestStart=currentStartIdx;
            }
            lastSeen.put(c, i);
        }
        String result = str.substring(longestStart, longestEnd);
        return result;
    }


    public static String maxSubstringFinder(String str){
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<String> subStrings = new ArrayList<>();
        if (str.isEmpty()) return "";
        for (int i=0; i < str.length(); i++){                 // ---------O(n)------------------------------------------
            if (map.containsKey(str.charAt(i))){              // if iteration finds any dublicate char at this index....
                subStrings.add(result.toString());            // Add fabricated String to ArrayList....................
                result.setLength(0);                          // Clear String Builder........
                i = map.get(str.charAt(i));                   // Move i to first occurance of dublicated character.....
                map.clear();                                  // Clear HashMap.......................
            } else {
                result.append(str.charAt(i));                 // Until a dublicate exist...move pointer rigth and append new character
                map.put(str.charAt(i), i);                    // Put Character with its index..........................
                if (i == str.length() - 1) subStrings.add(result.toString());  // edge case -> end of String and no dublicate character
            }
        }
        System.out.println(subStrings);
        return subStrings.stream().max(comparing(String::length)).get();
    }

    private static String getLongestNonDupSubstringMySol1(String source){
        ArrayList<SubString> subStrings = new ArrayList<>();

        subStrings.add(new SubString(source.charAt(0), 0));

        for (int i = 1; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            int finalI = i;
            subStrings.forEach(s -> s.addWithControl(currentChar, finalI));
            subStrings.add(new SubString(currentChar, finalI));
        }

        subStrings.sort((o1, o2) -> o2.getLength() > o1.getLength() ? 1 : -1);

        return subStrings.get(0).substring;
    }
}

class SubString{
    public String substring;
    public int startIndex, endIndex;
    public char startingChar;
    public boolean isClosed = false;

    public SubString(char startingChar, int startIndex){
        this.startingChar = startingChar;
        this.startIndex = startIndex;
        substring = String.valueOf(startingChar);
    }

    public void addWithControl(char charToAdd, int index){
        if (!isClosed){
            isClosed = substring.contains(String.valueOf(charToAdd));

            if (!isClosed)
            {
                endIndex = index;
                substring += charToAdd;
            }
        }
    }

    public int getLength(){return endIndex - startIndex + 1;}
}


package groupWork;

import java.util.*;

public class Algo_02_String_GroupingAnagrams {

    /*     question 2

    Write a function that takes in an array of strings and groups anagrams together. Anagrams are strings made up of
    exactly the same letters, where order doesn't matter.
For example, "cinema" and "iceman" are anagrams; similarly, "foo" and "ofo" are anagrams.
Your function should return a list of anagram groups in no particular order.
Sample Input
	words = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
Sample Output
	[["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]
     */

    public static void main(String[] args) {

        String [] words = {"yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"};

        System.out.println(groupAnagrams(words));
        //   System.out.println(Arrays.deepToString(groupingAnagrams(words)));

    }

    public static List< List<String> > groupAnagrams(String [] words) {   // best solution for me
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : words) {

            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            anagrams.putIfAbsent(sortedWord, new ArrayList<>());
            anagrams.get(sortedWord).add(word);
        }
        return new ArrayList<>(anagrams.values());
    }


    public static String[][] groupingAnagrams(String[] words) {   // my try. doesn't work because array size is fixed
        // but number anagrams must be flexible
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            for (int j = i + 1; j < words.length; j++) {
                chars = words[j].toCharArray();
                Arrays.sort(chars);
                String temp = new String(chars);
                if (!words[j].isEmpty() && sorted.equals(temp)) {
                    System.out.println(words[i] + " " + words[j]);
                    result[i][0] = words[i];
                    result[i][1] = words[j];
                    words[j] = "";
                    break;
                }
            }
        }
        return result;
    }


}

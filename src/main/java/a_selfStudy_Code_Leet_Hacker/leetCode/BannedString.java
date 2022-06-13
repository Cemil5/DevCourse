package a_selfStudy_Code_Leet_Hacker.leetCode;

import java.util.HashMap;

/*

Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"
 */
public class BannedString {
    public static void main(String[] args) {
      //  System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));   // ball
     //   System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"})); // ball
        System.out.println(mostCommonWord( "a, a, a, a, b,b,b,c, c", new String[]{"a"}));   // b
        System.out.println(mostCommonWord( "abc abc? abcd the jeff!", new String[]{"abc","abcd","jeff"}));  // jeff

//        Input
//        "abc abc? abcd the jeff!"
//                ["abc","abcd","jeff"]
//        Output
//        "d"
//        Expected
//        "the"
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace(",", " ");
        for (String str : banned){
            paragraph = paragraph.replace(str, "");
        }
        String input="";
        for (Character ch : paragraph.toCharArray()){
            if (Character.isLetter(ch)||Character.isSpaceChar(ch)) {
                input += ch;
            }
        }
        input = input.replace("  ", " ").trim();
        HashMap<String, Integer> map = new HashMap<>();
        int max =0;
        String result ="";
        for (String str : input.split(" ")){
            map.put(str, map.getOrDefault(str, 0)+1);
            if (map.get(str)>max){
                result = str;
                max = map.get(str);
            }
        }
        return result;
    }
}

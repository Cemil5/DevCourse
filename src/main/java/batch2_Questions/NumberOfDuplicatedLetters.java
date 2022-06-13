package batch2_Questions;
/*
Problem : Count the number of Duplicated Letters
Level-3
Write a function that will return the count of distinct case-insensitive alphabetic characters and
numeric digits that occur more than once in the input string. The input string can be assumed to
contain only alphabets (both uppercase and lowercase) and numeric digits.
Example:
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */

import java.util.HashMap;
import java.util.Map;

public class NumberOfDuplicatedLetters {


    public static int repeatCount(String str) {

        int[] indexes = new int[100];
        int count = 0;
        for (char eachChar : str.toLowerCase().toCharArray()) {
            indexes[eachChar - 48]++;
            if (indexes[eachChar - 48] == 2) {
                count++;
            }
        }
        return count;
    }

    public static int duplicateCount(String text) {
        int duplicateCount=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <text.length() ; i++) {
            if (map.containsKey(Character.toUpperCase(text.charAt(i)))) map.put(Character.toUpperCase(text.charAt(i)),map.get(Character.toUpperCase(text.charAt(i)))+1);
            else map.put(Character.toUpperCase(text.charAt(i)),1);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue()>=2) duplicateCount++;
        }
        return duplicateCount;
    }
}

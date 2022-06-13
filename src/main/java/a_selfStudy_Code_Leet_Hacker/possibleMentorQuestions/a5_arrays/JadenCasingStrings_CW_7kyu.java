package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a5_arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;

public class JadenCasingStrings_CW_7kyu {
    /*
    7 kyu
    Jaden Casing Strings
    Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013). Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known for almost always capitalizing every word. For simplicity, you'll have to capitalize each word, check out how contractions are expected to be in the example below.

Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.

Example:

Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
Note that the Java version expects a return value of null for an empty string or null.
     */

    public String toJadenCase1(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
//        phrase = (phrase.charAt(0) + "").toUpperCase(Locale.ROOT) + phrase.substring(1);
//        for (int i = 1; i < phrase.length(); i++) {
//            char ch = phrase.charAt(i);
//            if (ch == ' ') {
//                ch = phrase.charAt(++i);
//                phrase = phrase.replace(ch+"", Character.toString(ch-32));
//            }
//        }
        String result ="";
        String [] strings = phrase.split(" ");
        for (String str : strings){
            result += (str.charAt(0) + "").toUpperCase(Locale.ROOT) + str.substring(1) + " ";
        }
        return result.trim();
    }

    // my solution
    public String toJadenCase32(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return "";
        }
        String result ="";
        String [] strings = phrase.split(" ");
        for (String str : strings){
            result += (str.charAt(0) + "").toUpperCase(Locale.ROOT) + str.substring(1) + " ";
        }
        return result.trim();
    }

    public String toJadenCase55(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return "";
        }

        char[] array = phrase.toCharArray();

        for(int i = 0; i < array.length; i++) {
            if(i == 0 || array[i-1] == ' ') {
                array[i] = Character.toUpperCase(array[i]);
            }
        }
        return new String(array);
    }

    public String toJadenCase4(String phrase) {
        if (null == phrase || phrase.length() == 0) {
            return null;
        }
        return Arrays.stream(phrase.split(" "))
                .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1))
                .collect(Collectors.joining(" "));
    }

    public String toJadenCase(String phrase) {
        if(phrase == null || phrase.isEmpty()) return null;
        return Arrays.stream(phrase.split("\\s+"))
                .map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
                .collect(Collectors.joining(" "));
    }

    public String toJadenCase6(String phrase) {
        if(phrase == null || phrase.isEmpty()){
            return null;
        }
        List<String> result =new ArrayList<>();
        for (String s: phrase.split(" ")){
            result.add(s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase());
        }
        return String.join(" ", result);
    }

    public String toJadenCase33(String phrase) {
        if(phrase == null || phrase.isEmpty())
            return null;
        else
            return Arrays.stream(phrase.split(" "))
                    .reduce("", (a, b) -> a + " " + b.substring(0,1).toUpperCase() + b.substring(1)).trim();
    }

    @Test
    public void test() {
        assertEquals("toJadenCase doesn't return a valide JadenCase String! try again please :)", "Most Trees Are Blue", toJadenCase("most trees are blue"));
    }

    @Test
    public void testNullArg() {
        assertEquals("Must return null when the arg is null", "", toJadenCase(null));
    }

    @Test
    public void testEmptyArg() {
        assertEquals("Must return null when the arg is empty string","", toJadenCase(""));
    }
}

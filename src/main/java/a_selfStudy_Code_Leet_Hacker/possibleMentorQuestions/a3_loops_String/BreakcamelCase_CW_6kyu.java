package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a3_loops_String;

import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;

/*
Break camelCase
Complete the solution so that the function will break up camel casing, using a space between words.
6 kyu
Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""
 */
public class BreakcamelCase_CW_6kyu {

    // my solution
    public static String camelCase1(String input) {

        String result = "";
        String word;
        int i =0;
        while (i < input.length()) {
            char ch = input.charAt(i);
            word = "";
            while (!(ch >= 'A' && ch <= 'Z') && i<input.length()) {
                word += ch;
                if (i<input.length()-1) {
                    ch = input.charAt(++i);
                } else {
                    i++;
                }
            }
            if (i < input.length()) {
                word += " "+ch;
                i++;
            }
            result += word;
        }

        return result;
    }

    public static String camelCase2(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }

    public static String camelCase3(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output = Character.isUpperCase(input.charAt(i)) ? output + " " + input.charAt(i) : output + input.charAt(i);
        }
        return output;
    }

    static String camelCase4(String input) {
        var separated = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                separated.append(' ');
            }
            separated.append(c);
        }
        return separated.toString();
    }

    public static String camelCase5(String input) {
        return String.join(" ", input.split("(?=[A-Z])"));
    }

    public static String camelCase6(String input) {
        String result = "";
        String[] array = input.split("");

        for (int i = 0; i < input.length(); i++) {
            if (array[i].equals(array[i].toUpperCase())) {
                result += " " + array[i];
            }else {
                result += array[i];
            }
        }
        return result;
    }

    public static String camelCase(String input) {
        return input.chars()
                .mapToObj(ch -> Character.isUpperCase(ch) ? " " + (char) ch : String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

    @Test
    public void tests() {
        assertEquals("Incorrect", "camel Casing", camelCase("camelCasing"));
        assertEquals("Incorrect", "camel Casing Test", camelCase("camelCasingTest"));
        assertEquals("Incorrect", "camelcasingtest", camelCase("camelcasingtest"));
    }
}

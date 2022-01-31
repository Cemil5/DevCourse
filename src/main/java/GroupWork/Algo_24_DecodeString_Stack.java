package GroupWork;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
Question #24
Decode String(Leetcode #394)
Difficulty :Medium Category :Stacks
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
repeat numbers, k. For example, there won't be input like 3a or 2[4].
Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:
Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
Constraints:
• 1 <= s.length <= 30
• s consists of lowercase English letters, digits, and square brackets '[]'.
• s is guaranteed to be a valid input.
• All the integers in s are in the range [1, 300]
 */

public class Algo_24_DecodeString_Stack {
    @DataProvider(name = "data")
    public Object[][] input(){
        return new Object[][]{
                {"3[a]2[bc]",       "aaabcbc"},
                {"3[a2[c]]",        "accaccacc"},
                {"2[abc]3[cd]ef",   "abcabccdcdcdef"},
                {"abc3[cd]xyz",     "abccdcdcdxyz"},
                {"3[ac2[bb]]",      "acbbbbacbbbbacbbbb"},
                {"3[a]12[bc]",      "aaabcbcbcbcbcbcbcbcbcbcbcbc"},
        };
    }

    @Test(dataProvider = "data")
    public void test(String input, String expected){
        Assert.assertEquals(myDecode(input), expected);
    //    Assert.assertEquals(decodeString(input), expected);
    //    Assert.assertEquals(decodeString1(input), expected);
    //    Assert.assertEquals(decodeString5(input), expected);
        Assert.assertEquals(decodeString2(input), expected);
    //    Assert.assertEquals(getCrMySol3(input), expected);
    }

    public String myDecode(String input){   // good enough without slack
        while (input.contains("]")){
            int closingBracket = input.indexOf("]");
            int openingBracket = input.substring(0, closingBracket).lastIndexOf("[");
            StringBuilder sb = new StringBuilder();   // to find k
            for (int i = Math.max(0,openingBracket-3); i<openingBracket; i++){
                char ch = input.charAt(i);
                if (Character.isDigit(ch)) sb.append(ch);
            }
            int k = Integer.parseInt(sb.toString());

            String temp =input.substring(openingBracket+1, closingBracket);
            String decoding = "";
            for (int i = 1; i<=k; i++){
                decoding += temp;
            }
            temp = input.substring(0, openingBracket-sb.length()) + decoding + input.substring(closingBracket+1);
            input = temp;
        }
        return input;
    }

    // Using two stacks (number of times stack and character stack)
    public static String decodeString2(String str) {  // best solution for me with two stacks and after modification
        if (str == null || str.length() == 0)
            return "";
        Stack<Integer> numStack = new Stack<>();
        Stack<String>  strStack = new Stack<>();
        String result = "";
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) { // if it is NUMBER, push into integer stack
                StringBuilder temp = new StringBuilder();
                while (i < str.length() && Character.isDigit(str.charAt(i))) { // enable to get two or more digits
                    temp.append(str.charAt(i));
                    i++;
                }
                numStack.push(Integer.parseInt(temp.toString()));
            } else {
                if (ch == '[') {
                    strStack.push(result);
                    result = "";
                } else if (ch == ']') {
                    int num = numStack.pop();
                    result = strStack.pop() + result.repeat(Math.max(0, num));
                    // result.repeat(Math.max(0, num)) means: for (int j = 0 ; j < num; j++) sb.append(result);
                } else {
                    result += ch;
                }
                i++;
            }
        }
        return result;
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> decodedString = new ArrayList<>();
                // get the encoded string
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                // pop [ from the stack
                stack.pop();
                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                // decode k[decodedString], by pushing decodedString k times into stack
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
            // push the current character to stack
            else {
                stack.push(s.charAt(i));
            }
        }
        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }

    public static String decodeString1(String s) {      // gives error for the last input ( k>10)

        Stack<Integer> numbers = new Stack<>();
        Stack<String> letters = new Stack<>();
        String resultString = "";
        int repeatTimes = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) { // if digit, counting repeat times
                repeatTimes = s.charAt(i) - 48;
                numbers.push(repeatTimes);
            }else if (s.charAt(i) == '[') {        // if '[', pushing result string to the letters' stack
                letters.push(resultString);
                resultString = "";
            }else if (s.charAt(i) == ']') {         // if ']', popping repeat times and calculating/adding to the string
                int k = numbers.pop();
                String tempString = letters.pop();
                for (int j = 0; j < k; j++) {
                    tempString += resultString;
                }
                resultString = tempString;
            }else {
                resultString += s.charAt(i);        // if alphabetic, then adding it
            }
        }
        return resultString;
    }

    public String decodeString5(String encoded) {
        String result = "";
        String k = "";
        String partialText = "";
        Stack<Character> stack = new Stack<>();
        boolean isInnerEncoded = false;
        int i = 0;

        while (i < encoded.length()) {
            if (Character.isLetter(encoded.charAt(i))) {
                result += "" + encoded.charAt(i);
                i++;
            } else {
                while (encoded.charAt(i) != '[') {
                    k += "" + encoded.charAt(i);
                    i++;
                }
                stack.push('[');
                i++;
                while (!stack.empty()) {
                    if (encoded.charAt(i) == ']') {
                        stack.pop();
                        if (stack.empty()) {
                            i++;
                            continue;
                        }
                    } else if (encoded.charAt(i) == '[') {
                        stack.push('[');
                        isInnerEncoded = true;
                    }
                    partialText += "" + encoded.charAt(i);
                    i++;
                }
                if (isInnerEncoded) {
                    partialText = decodeString5(partialText);
                }
                int times = Integer.parseInt(k);
                for (int j = 0; j < times; j++) {
                    result += partialText;
                }
            }
            partialText = "";
            k="";
        }
        return result;
    }

    // after getting the right point from @sezginm abi's solution. tested and passed at leetcode
    // but there is no stack in this solution. just for a diff approach...
    public static String getCrMySol3(String s){
        while (s.contains("[")){
            String generatedValue = "";//holds the String value that we generate based on the occurrence such as "aaaa"
            String occurrenceStr = "";//holds the occurrence value as str such as "22"
            int occurrenceInt = 0;
            int lastIndexOfOpeningBracket = s.lastIndexOf("[");
            int counterClosingBracketIndex = s.indexOf("]", lastIndexOfOpeningBracket);
            int lastIndexOfOccurrenceNumber = lastIndexOfOpeningBracket - 1;
            String valueBtwnBrackets = s.substring(lastIndexOfOpeningBracket + 1, counterClosingBracketIndex);

            while (lastIndexOfOccurrenceNumber > 0 &&
                    "0123456789".contains(s.substring(lastIndexOfOccurrenceNumber - 1, lastIndexOfOccurrenceNumber))){
                lastIndexOfOccurrenceNumber--;
            }//this while is for getting the right occurrence number that is situated before opening brackets such as 52

            occurrenceStr = s.substring(lastIndexOfOccurrenceNumber, lastIndexOfOpeningBracket);
            occurrenceInt = Integer.parseInt(occurrenceStr);

            for (int i = 0; i < occurrenceInt; i++)
                generatedValue += valueBtwnBrackets; //generating the value based on the occurrence number

            String firstPart = s.substring(0, lastIndexOfOccurrenceNumber);
            String secondPart = s.substring(counterClosingBracketIndex + 1);
            s = firstPart + generatedValue + secondPart;
        }
        return s;
    }

}

package batch2_Questions;

import java.util.HashMap;
import java.util.Map;

/*
JDA2 Interview Prep Algo Question 3
Problem: Roman to Integer
Easy
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol Value
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is
simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
• I can be placed before V (5) and X (10) to make 4 and 9.
• X can be placed before L (50) and C (100) to make 40 and 90.
• C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
Constraints:
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(convertRomanToInteger("III"));
        System.out.println(convertRomanToInteger("LVIII"));
        System.out.println(convertRomanToInteger("MCMXCIV"));
    }

    public static int romanToInt(String str) {
        int ans = 0, num = 0;
        for (int i = str.length()-1; i >= 0; i--) {
            switch(str.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans)
                ans -= num;
            else ans += num;
        }
        return ans;
    }

    public int romanToInt2(String s) {

        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));

            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public static int romanToInt3(String s) {
        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('I', 1);                               // assigning all key and values to the map in a default
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        int total = 0, carry = valueMap.get(s.charAt(0));   // assigning value of first element of string  to the carry

        for(int index = 1; index < s.length(); index++) {   // beginning with index 1
            int value = valueMap.get(s.charAt(index));      // assigning value of index 1 to the value
            if(carry >= value) {                            // assumption: always value of first element of string (carry) is bigger than next element (value)
                total += carry;                             // if then add to the total
            } else {
                total -= carry;                             // if not subtract from the total
            }
            carry = value;                                  // for next iteration change carry with value
        }
        if(carry != 0) {                                    // if carry is not 0 (end of the string) add to the total
            total += carry;
        }
        return total;
    }

    public static int romanToInt4(String s) {

        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum=map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
            if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))){
                sum+=map.get(s.charAt(i));
            }else{
                sum=sum-map.get(s.charAt(i));
            }
        }
        return sum;
    }

    // Ali
    public int romanToInt5(String s) {

        Map<Character, Integer> romanValues = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50,
                                                     'C', 100, 'D', 500, 'M', 1000);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'I' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X') {
                    result -= 1;
                    continue;
                }
            }

            if (s.charAt(i) == 'X' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') {
                    result -= 10;
                    continue;
                }
            }

            if (s.charAt(i) == 'C' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M') {
                    result -= 100;
                    continue;
                }
            }
            result += romanValues.get(s.charAt(i));
        }
        return result;
    }

    public int getValue(char ch) {

        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    static int convertRomanToInteger(String input) {
        int result = 0;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean exception = false;
            if (i != chars.length - 1) {
                if (chars[i] == 'I') {
                    if (chars[i + 1] == 'V' || chars[i + 1] == 'X'){
                        if (chars[i + 1] == 'V') {
                            result += 4;
                        } else {
                            result += 9;
                        }
                        exception = true;
                    }
                } else if (chars[i] == 'X') {
                    if (chars[i + 1] == 'L' || chars[i + 1] == 'C') {
                        if (chars[i + 1] == 'L') {
                            result += 40;
                        } else {
                            result += 90;
                        }
                        exception = true;
                    }
                } else if (chars[i] == 'C') {
                    if (chars[i + 1] == 'D' || chars[i + 1] == 'M') {
                        if (chars[i + 1] == 'D') {
                            result += 400;
                        } else {
                            result += 900;
                        }
                        exception = true;
                    }
                }
                if (exception){
                    i++;
                }
            }

            if (!exception) {
                switch (chars[i]) {
                    case 'I':
                        result += 1;
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'M':
                        result += 1000;
                        break;
                }
            }
        }
        return result;
    }




}

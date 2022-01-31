package GroupWork;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Stack;
/**
Question #25
Basic Calculator
Difficulty :Medium     Category :Stacks

Given a string s which represents an expression, evaluate this expression and return its value.
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
Example 1:
Input: s = "3+2*2"
Output: 7
Example 2:
Input: s = " 3/2 "
Output: 1
Example 3:
Input: s = " 3+5 / 2 "
Output: 5

Constraints:
•	1 <= s.length <= 3 * 105
•	s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
•	s represents a valid expression.
•	All the integers in the expression are non-negative integers in the range [0, 231 - 1].
•	The answer is guaranteed to fit in a 32-bit integer.    */

public class Algo_25_BasicCalculator {
    @DataProvider
    public Object[][] input(){
        return new Object[][]{
//                {"3+2*2",           7},
//                {" 3/2 ",           1},
//                {" 3+5 / 2 ",       5},
//                {"13 + 10 * 10",    113},
//                {"10*10+13",        113},
                {"5+5+10*10+13",    123},
                {"5+5+10*10+13+5+5",    133},
                {"5+5+10*10+13-5-5",    113},
        };
    }
    @Test(dataProvider = "input")
    public void test(String input, int expected){
    //    Assert.assertEquals(myCalculator(input), expected);
    //    Assert.assertEquals(calculateII(input), expected);
        Assert.assertEquals(calculate(input), expected);
    }

    public int myCalculator(String input){
        input = input.replace(" ", "");
        int result = 0;
        Stack<Integer> numPre = new Stack<>();
        Stack<Integer> numPost = new Stack<>();
        Stack<Character> opsPre = new Stack<>();
        Stack<Character> opsPost = new Stack<>();
        int priority = 0;
        int i=0;
        while (i< input.length()){
            char ch = input.charAt(i);
            int num = 0;
            int base = 1;
            boolean isNum = false;
            while (Character.isDigit(ch)){
                num = num * base + (ch - '0');
                base *= 10;
                isNum = true;
                i++;
                if (i < input.length()) ch = input.charAt(i);
                else break;
            }
            if (isNum) {
                numPre.push(num);
                num = 0;
                isNum = false;
            }
            if (ch == '/' || ch == '*' || ch == '-' || ch == '+'){
                opsPre.push(ch);
                i++;
                if (ch == '/' || ch == '*')
                    priority++;
            }
        }
        System.out.println(opsPre);
        System.out.println(numPre);
        char ch  = ' ';

        while (!opsPre.isEmpty() || !opsPost.isEmpty()){
            boolean isPre = false;
          if (!opsPre.isEmpty()) {
              ch = opsPre.pop();
              isPre = true;
          } else ch = opsPost.pop();
          if (priority == 0 || ch == '/' || ch == '*' ) {
              if (ch == '/' || ch == '*' ) priority--;
              int n2 = isPre || numPost.isEmpty() ? numPre.size()>1 ? numPre.pop() : numPost.pop() : numPost.pop();
              int n1 = numPre.pop();
              switch (ch) {
                  case '*':
                      result = n1 * n2;
                      break;
                  case '/':
                      result = n1 / n2;
                      break;
                  case '-':
                      result = n1 - n2;
                      break;
                  case '+':
                      result = n1 + n2;
                      break;
              }
              numPre.push(result);
          } else {
             if (numPre.size()>0 && (ch == '-' || ch == '+' )) {
                 opsPost.push(ch);
                 numPost.push(numPre.pop());
             }
          }
        }
        return numPre.size() > 0 ? numPre.pop() : -1;
    }


    public static int calculateII(String s) {       // best solution with stack

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            // calculate the number if more than one digit
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static int calculate(String str) {           // best solution without stack
        if (str == null || str.isEmpty()) return 0;
        int length = str.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}

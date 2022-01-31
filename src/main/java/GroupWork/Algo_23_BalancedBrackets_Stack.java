package GroupWork;
/**
Question # 23
Description: Balanced Brackets
Difficulty: Medium Category: Stacks
Write a function that takes in a string made up of brackets ( ( , [ , { , ) , ] , and } ) and other
optional characters. The function should return a boolean representing whether the string is
balanced with regards to brackets.
A string is said to be balanced if it has as many opening brackets of a certain type as it has
closing brackets of that type and if no bracket is unmatched. Note that an opening bracket
can't match a corresponding closing bracket that comes before it, and similarly, a closing
bracket can't match a corresponding opening bracket that comes after it. Also,brackets can't
overlap each other as in [(])
Sample Input
string = "([])(){}(())()()"
Sample Output
true // it's balanced
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Algo_23_BalancedBrackets_Stack {
    @DataProvider(name = "data")
    public Object[][] getData(){
        return new Object[][]{
                {"(v)",             true},
                {"([])(){}(())()()",true},
                {"([asdasasd])(()", false},
                {"fgfg(ss[s]s)(s){s}s((ss))s(s)s(s)}",false},
                {"",                true},
                {"c",               true},
                {"d(",              false}
        };
    }

    @Test(dataProvider = "data")
    public void test(String inputString, boolean expectedResult){
        Assert.assertEquals(isBracketsBalanced1(inputString), expectedResult);
        Assert.assertEquals(isBracketsBalanced2(inputString), expectedResult);
    }

    boolean isBracketsBalanced1(String str){

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();

        for(Character ch : str.toCharArray()){
            if (ch.equals('(') || ch.equals('[') || ch.equals('{')) stack.push(ch);
            else if(map.containsKey(ch)) {
                if (stack.empty() || stack.pop() != map.get(ch)) return false;
            }
        }

        return stack.size()==0;
    }

    boolean isBracketsBalanced2(String input){
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.size() == 0) return false;
                switch (stack.pop()) {
                    case '(':
                        if (ch != ')') return false;
                        break;
                    case '[':
                        if (ch != ']') return false;
                        break;
                    case '{':
                        if (ch != '}') return false;
                        break;
                }
            }
        }
        return stack.size() == 0;
    }

}

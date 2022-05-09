package dataStructure.Stack;

public class InfixToPostfix {

    static int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        String result = "";
        MyStack stack = new MyStack();

        for (int i = 0; i<exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to result.
            if (Character.isLetterOrDigit(c) && !Character.isSpaceChar(c))
                result += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')', pop and output from the stack until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                stack.pop();
            }
            else if (!Character.isSpaceChar(c)) {   // an operator is encountered
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {

        String exp = "a+b*(c^d-e)^(f+g*h)-i";   // output : abcd^e-fgh*+^*+i-
      //  exp = "(a+b)+c";
        System.out.println(exp);
        System.out.println(infixToPostfix(exp));

    }
}

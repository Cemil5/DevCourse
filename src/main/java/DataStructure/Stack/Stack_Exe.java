package DataStructure.Stack;

public class Stack_Exe {
    public static void main(String[] args) {

        String str = "((A+B) + (C+D))+{A+B}";
        System.out.println(isBalanced(str));


    }
    public static boolean isBalanced(String str) {
        MyStackGen<Character> stack = new MyStackGen<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
           //     System.out.println("c : " + c);
            } else if (c == ')' || c == '}' || c == ']'){
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char pop = stack.pop();
              //      System.out.println("pop : " + pop);
                    switch (c){
                        case ')' :
                            if (pop != '(') return false;
                            break;
                        case '}' :
                            if (pop != '{') return false;
                            break;
                        case ']' :
                            if (pop != '[') return false;
                            break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}

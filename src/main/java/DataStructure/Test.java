package DataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(5);

        Stack<Integer> stack =new Stack<>();

        int a = 1;
        int[] b = {1};
        String str = "cc";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("stringBuffer");
        Integer i = 1;
        passByValue(a, b, str, stringBuffer, i);
        System.out.println("a = " + a);                     // a = 1
        System.out.println("b = " + Arrays.toString(b));    // b = [2]
        System.out.println("str = " + str);                 // str = cc
        System.out.println("stringBuffer = " + stringBuffer);   // stringBuffer = sbadd
        System.out.println("i = " + i);                     // i = 1
    }

    private static void passByValue (int a, int[] b, String s, StringBuffer sbf, Integer i) {
        a = a + 1;
        b[0] = b[0] + 1;
        s += "add";
        sbf.append("add");
        i = i + 1;
    }

}

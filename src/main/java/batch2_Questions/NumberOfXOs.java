package batch2_Questions;

import java.util.Locale;

public class NumberOfXOs {
    public static void main(String[] args) {
        System.out.println(isBalanced("ooxx"));
        System.out.println(isBalanced("oooxx"));
    }

    public static boolean isBalanced(String str){
        str = str.toLowerCase(Locale.ROOT);
        int x =0;
        int o = 0;
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if (ch == 'x'){
                x++;
            } else if (ch == 'o'){
                o++;
            }
        }
        return x == o;
    }
}

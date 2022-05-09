package groupWork;
/*
Question # 10
Description:
Reverse Words in String
Difficulty: Medium Category: Array
Write a function that takes in a string of words separated by one or more whitespaces and
returns a string that has these words in reverse order. For example, given the string "tim is
great", your function should return "great is tim". For this problem, a word can contain
special characters, punctuation, and numbers. The words in the string will be separated by
one or more whitespaces, and the reversed string must contain the same whitespaces as the
original string. For example, given the string "whitespaces 4" you would be expected to
return "4 whitespaces". Note that you're not allowed to use any built-in split or reverse
methods/functions. However, you are allowed to use a built-in join method/function. Also
note that the input string isn't guaranteed to always contain words.
Sample Input
string = "Cydeo is the best!"
Sample Output
"best! the is Cydeo"
 */
public class Algo_10_String_ReverseWords {
    public static void main(String[] args) {
        String str = "Cydeo   is the best!";
        System.out.println(reverseWord(str));
    }

    // my solution
    public static StringBuilder reverseWord(String str){
        StringBuilder result = new StringBuilder("");
        int end =0;
        for (int i = str.length()-1; i>=0; i--){
            if (end == 0 && str.charAt(i) != ' ') end = i+1;
            else {
                if (end != 0 && str.charAt(i) == ' ') {
                    result.append(str.substring(i + 1, end)).append(" ");
                    end =0;
                } else if (end == 0 && str.charAt(i) == ' ') result.append(" ");
                if (i == 0 && end !=0) result.append(str.substring(i, end));
            }
        }
        return result.append("");
    }



}

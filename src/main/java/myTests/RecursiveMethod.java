package myTests;

public class RecursiveMethod {

    public static void main(String[] args) {
       // Use recursion to add all the numbers up to 5.
        int result = sum(5);
        System.out.println(result);

     //   Use recursion to add all the numbers between 5 and 10.
        int result2 = sum(5, 10);
        System.out.println(result2);
    }

    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }
    /**
     When the sum() function is called, it adds parameter k to the sum of all numbers smaller than k and returns the result.
     When k becomes 0, the function just returns 0. When running, the program follows these steps:

10 + sum(9)
10 + ( 9 + sum(8) )
10 + ( 9 + ( 8 + sum(7) ) )
...
10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + sum(0)
10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0
Since the function does not call itself when k is 0, the program stops there and returns the result.
     */

    public static int sum(int start, int end) {
        if (end > start) {
            return end + sum(start, end - 1);
        } else {
            return end;
        }
    }
}

package a_selfStudy_Code_Leet_Hacker.codeWars.sentToPossibleMentorQuestions;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/*
Persistent Bugger.
6kyu

Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.

For example (Input --> Output):

39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
4 --> 0 (because 4 is already a one-digit number)
 */
public class Persistence_CodeWars {

    int persistence(int num) {
        int count = 0;
        while (num > 9) {
            String str = num + "";
            char[] nums = str.toCharArray();
            int temp = 1;
            for (int i = 0; i < str.length(); i++) {
                temp *= (nums[i] - 48);
            }
            num = temp;
            count++;
        }
        return count;
    }

    public static int persistence(long n) {
        long m = 1, r = n;

        if (r / 10 == 0)
            return 0;

        for (r = n; r != 0; r /= 10)
            m *= r % 10;

        return persistence(m) + 1;

    }

    public static int persistence1(long n) {
        int times = 0;
        while (n >= 10) {
            n = Long.toString(n).chars().reduce(1, (r, i) -> r * (i - '0'));
            times++;
        }
        return times;
    }


    /**
     * given a positive integer produce its multiplicative persistence
     * @param n a positive integer
     * @return the multiplicative persistence of n
     */
    public static int persistence5(long n) {
        if (n < 10) {
            return 0;
        }
        return 1 + persistence5(multiplyDigits(n));
    }
    /**
     * given an integer produce the product of the given integers digits.
     * example: multiplyDigits(785) = 7 * 8 * 5 = 280
     * @param n
     * @return the product of the digits that comprise n
     */
    private static long multiplyDigits(long n) {
        if (n < 10) {
            return n;
        }
        return n % 10 * multiplyDigits(n / 10);
    }


    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, persistence(39));
        assertEquals(0, persistence(4));
        assertEquals(2, persistence(25));
        assertEquals(4, persistence(999));
    }
}

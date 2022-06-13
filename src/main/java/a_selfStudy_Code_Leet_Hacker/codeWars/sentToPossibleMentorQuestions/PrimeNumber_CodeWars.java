package a_selfStudy_Code_Leet_Hacker.codeWars.sentToPossibleMentorQuestions;

import org.testng.annotations.Test;

import java.util.HashSet;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
/*
Is a number prime?

Define a function that takes an integer argument and returns a logical value true or false depending on if the integer is a prime.

Per Wikipedia, a prime number ( or a prime ) is a natural number greater than 1 that has no positive divisors other than 1 and itself.

Requirements
You can assume you will be given an integer input.
You can not assume that the integer will be only positive. You may be given negative numbers as well ( or 0 ).
NOTE on performance: There are no fancy optimizations required, but still the most trivial solutions might time out. Numbers go up to 2^31 ( or similar, depending on language ). Looping all the way up to n, or n/2, will be too slow.
Example
is_prime(1)  // false
is_prime(2)  // true
is_prime(-1) // false
 */

public class PrimeNumber_CodeWars {


    public static boolean isPrime(int num) {
        HashSet<Integer> prime = new HashSet<>();
        prime.add(2);
        if (prime.contains(num)) return true;
        if (num > 2) {
            for (int i = 2; i <= num/2; i++) {
                if (num % i == 0) {
                    return false;
                }
                if(i % 2 != 0){
                    i++;
                }
            }
        } else return false;
        prime.add(num);
        return true;
    }

    @Test
    public void testBasic() {
        assertFalse("0  is not prime", isPrime(0));
        assertFalse("1  is not prime", isPrime(1));
        assertTrue("2  is prime", isPrime(2));
        assertTrue("73 is prime", isPrime(73));
        assertFalse("75 is not prime", isPrime(75));
        assertFalse("-1 is not prime", isPrime(-1));
        assertFalse("1336336429  is not prime", isPrime(1336336429 ));
    }

    @Test
    public void testPrime() {
        assertTrue("3 is prime", isPrime(3));
        assertTrue("5 is prime", isPrime(5));
        assertTrue("7 is prime", isPrime(7));
        assertTrue("41 is prime", isPrime(41));
        assertTrue("5099 is prime", isPrime(5099));
    }

    @Test
    public void testNotPrime() {
        assertFalse("4 is not prime", isPrime(4));
        assertFalse("6 is not prime", isPrime(6));
        assertFalse("8 is not prime", isPrime(8));
        assertFalse("9 is not prime", isPrime(9));
        assertFalse("45 is not prime", isPrime(45));
        assertFalse("-5 is not prime", isPrime(-5));
        assertFalse("-8 is not prime", isPrime(-8));
        assertFalse("-41 is not prime", isPrime(-41));
    }

}

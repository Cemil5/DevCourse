package myTests;
import java.util.Scanner;

/*
 * Complete the method **isPalindrome()** that will check if number is a palindrome. Print your result as a boolean (true or false). 
> Challenge: Do not convert int into a string!

Examples:
input: 1001
output: true

input: 1234
output: false
 */
public class __isPalindrome_numbers {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Enter a number:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.close();
		if (num>0) {
			System.out.println("isPalindrome(num) = " + isPalindromeWithRecursion(num));
		} else {
		   System.out.println("please enter a number bigger than 0");
		}
		
		repltAnswer(num);
	}
// ********* recursive methods
	//palindrome utility function
	public static int isPalindrome_util (int num, int revNum) {
		if (num == 0) {		// base condition; return if num=0
			return revNum;
		} else { 			//call utility function recursively
			revNum = isPalindrome_util(num / 10, revNum);
		}
		// Check if first digit of num and revNum are equal
		if (num % 10 == revNum % 10) {	// if yes, revNum will move with num
			return revNum / 10;
		} else { // exit
			return Integer.MIN_VALUE;
		}
	}
	//method to check if a given number is palindrome using palindrome utility function
	public static boolean isPalindromeWithRecursion(int num) {
		if (num < 0)
			num = (-num);
		int revNum = (num);
		return isPalindrome_util(num, revNum) == 0;
	}

	// *******************************************

	public static void isPalindromeWithIteration (int num) {
			
			int revertedNum=0, digitCount=1, revertingDigits=1, tempNum=num, numberOfTens=1;
			for (; numberOfTens<=num; numberOfTens*=10) {
				if (num/numberOfTens>=10) {
					digitCount++; 	//finds the number of digits
				} 
			}
			//System.out.println(digitCount);
				numberOfTens /=10;
				for (int j=1; j<=digitCount; j++, numberOfTens/=10) {
					revertedNum += (tempNum/numberOfTens)*revertingDigits; // reverts the digits starting from the highest digits of the original number

					tempNum = tempNum % numberOfTens; // removes the highest digit from tempNum
					revertingDigits *=10;
				//	System.out.println("i :"+ i + " reverting :" + reverting + " tempNum:" + tempNum + " revertedNum :"+ revertedNum);
				}

		System.out.println(num == revertedNum);
	}
	
		public static void repltAnswer (int num) {
			int temp = num;
			int newNum = 0;
			while (temp != 0) {
				newNum = newNum * 10 + temp % 10;
				temp = temp / 10;
			}
			System.out.println(num==newNum);
		}

	
	  public static void isPalindrome0(int num){
	    //WRITE YOUR CODE HERE
		  int d1=0,d2=0,d3=0,d4=0,d5=0,d6=0,d7=0,d8=0,d9=0, n=0;
		  
			
		  if (num>=100_000_000) {
			  d9 = num / 100_000_000;
			  num = num - d9*100_000_000;
			  if (n==0) {n=9;}
		  } 
		  if (num>=10_000_000) {
			  d8 = num / 10_000_000;
			  num = num - d8*10_000_000;
			  if (n==0) {n=8;}
		  } 
		  if (num>=1_000_000) {
			  d7 = num / 1_000_000;
			  num = num - d7*1_000_000;
			  if (n==0) {n=7;}
		  } 
		  if (num>=100_000) {
			  d6 = num / 100_000;
			  num = num - d6*100_000;
			  if (n==0) {n=6;}
		  } 
		  if (num>=10_000) {
			  d5 = num / 10_000;
			  num = num - d5*10_000;
			  if (n==0) {n=5;}
		  } 
		  if (num>=1_000) {
			  d4 = num / 1_000;
			  num = num - d4*1_000;
			  if (n==0) {n=4;}
		  } 
		  if (num>=100) {
			  d3 = num / 100;
			  num = num - d3*100;
			  if (n==0) {n=3;}
		  }  
		  if (num>=10) {
			  d2 = num / 10;
			  num = num - d2*10;
			  if (n==0) {n=2;}
		  } 
		  if (num>=0) {
			  d1 = num;
			  if (n==0) {n=1;}
		  } 
		  
		 // System.out.println(n);
		  if ((n==1)||(n==2 && d1==d2)||(n==3 && d1==d3)||(n==4 && d1==d4 && d2==d3)||(n==5 && d1==d5 && d2==d4)||(n==6 && d1==d6 && d2==d5 && d3==d4)||(n==7 && d1==d7 && d2==d6 && d3==d5)||(n==8 && d1==d8 && d2==d7 && d3==d6&& d4==d5)||(n==9 && d1==d9 && d2==d8 && d3==d7&& d4==d6)) {
			  System.out.println(true);
		  } else {
			  System.out.println(false);
		  }
		  	    
	  }

}

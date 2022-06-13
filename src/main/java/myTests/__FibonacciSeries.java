package myTests;
/*
 * Write a program to print Fibonacci series of n terms where n is declared by user :  0, 1, 1, 2, 3, 5, 8, 13, 21, 34,......
 */

public class __FibonacciSeries {

	public static void main(String[] args) {

//		ScannerTest scan = new ScannerTest(System.in);
//		System.out.println("Enter terms number:");
//		int termsNumber = scan.nextInt();
		int termsNumber = 8;
		System.out.println("group");
		group(termsNumber);
		
		System.out.println("--------------------");
		
		System.out.println("mySolution");
		mySolution(termsNumber);
		
		System.out.println("--------------------");

		System.out.println("recursion");

		int number = 8;

		//print first 8 numbers of fibonacci series
		System.out.println ("Fibonacci Series: First 8 numbers:");
		for (int i = 1; i <= number; i++)
		{
			System.out.print(fibonacci(i) + " ");
		}


		// recursion(termsNumber);
		//System.out.println("fibonacci(termsNumber) = " + fibonacci(termsNumber));

	}

	//method to calculate fibonacci series
	static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void group(int count) {	
		int num1 =0, num2 =1, temp =0;
		System.out.print(num1 + " ");
		for(int i=1; i<count; i++) {
			System.out.print(num2 + " ");
			temp = num1 + num2;
			num1 = num2;
			num2 = temp;
		}
	}

	public static void mySolution(int termsNumber) {
		int num1 =0, num2 =1;

		if (termsNumber <= 1) {
			System.out.println(0);
		} else {
			System.out.print("0 1 ");
			for (int i =2;i<termsNumber;i++) {
				int temp = num1 + num2;
				num1 = num2;
				num2 = temp;
				System.out.print(temp + " ");
			}
		}
	}

	public static void recursion(int count) {
		int num1 =0, num2 =1, temp=0;
		System.out.print(num1 + " ");
		if (count > 1) {
			System.out.print(num2 + " ");
			temp = num1 + num2;
			num1 = num2;
			num2 = temp;
			count = count--;
			recursion(count);
		} else
			return;
	}
	

	
}

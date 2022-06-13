package z2Hero_Questions;

import java.util.Scanner;

public class OrLogicWithSwitch {

	public static void main(String[] args) {

		Integer num = 5;

		switch (num) {
			case 5:
				System.out.println("fail");
			case 6:
				System.out.println("pass");
		}

		char grade = 'D';
		
		switch (grade) {
		case 'A': case 'B': case 'C':
			System.out.println("gggg");
		case 'D': case 'E':
			System.out.println("eeee");
		}

		String str = "Cydeo";

		System.out.println(str);


		Scanner scanMe = new Scanner(System.in);
		String name, lastName;

		System.out.println("Please write your name:");
		name = scanMe.next();

		System.out.println("Please write your last name:");
		lastName = scanMe.nextLine();

		System.out.print(name + " " + lastName);

		//I want to get name and last name of user from terminal
		//But this code only takes the name, not the last name
		//It directly jumps to the 17. line without waiting user to input the last name
		//This Dirty Java Code needs a RANGER to fix!

//		char grade = 'A';
//
//		switch (grade) {
//			case 'A':
//				System.out.println("Excellent");
//			case 'B':
//				System.out.println("Good");
//			case 'C':
//				System.out.println("Can be improved!");
//				break;
//			default:
//				System.out.println("No comment");
//		}
	}

}

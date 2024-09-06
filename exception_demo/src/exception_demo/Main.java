package exception_demo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num=0;
		boolean valid = false;
		while (!valid) {
			System.out.println("Please enter an integer: ");
			String num_str = in.nextLine();
			try {
				num = Integer.parseInt(num_str);
				// if we get here, number was valid
				valid=true;
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid \"number\" entered, please try again");
			}
		}
		
		
		// when we get here, num is valid...
		if (num>10) {
			System.out.println("the number is greater than 10!");
		} else {
			System.out.println("the number is less than or equal to 10");
		}
	}

}

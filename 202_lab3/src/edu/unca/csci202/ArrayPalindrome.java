/**
 * Lab3 - ArrayPalindrome class
 * 
 * 02/09/2024
 * 
 * Josie Anderson
 * 
 */
package edu.unca.csci202;

public class ArrayPalindrome {
	
	public static void main(String[] args) {
		ArrayPalindrome test = new ArrayPalindrome();
		test.isPalindrome("");

		test.isPalindrome("racecar");

		test.isPalindrome("macaroni");
		
		test.isPalindrome("kayak");
		
		test.isPalindrome(";-e!w!e-;");
	}
	
	// creating the three stacks
	
	ArrayStack<String> stack1;;
	ArrayStack<String> stack2;
	ArrayStack<String> reverse;
	
	
	public ArrayPalindrome() {
		//instantiating the new stacks 
		stack1 = new ArrayStack();
		stack2 = new ArrayStack();
		reverse = new ArrayStack();
		
	}
	
	/**
	 * 
	 * @param str String - takes in the string to have it's palindrome-ness checked 
	 * @return boolean - returns whether the string is a palindrome
	 */

	public boolean isPalindrome(String str){
		
		for(int i = 0; i < str.length(); i++) {
			String current = str.charAt(i) + ""; //turns the current char into a string to go on the stack
			stack1.push(current);
			stack2.push(current);
			
//			puts the string onto two stacks
		}
		
		for(int i = 0; i < str.length(); i++) {
			String working = stack2.pop();
			reverse.push(working);
			
//			pops each string off of the second stack and pushes it onto the reverse stack
		}
		
		
		for(int i = 0; i < str.length(); i++) { //compares the first stack
			String currentStr = stack1.pop();
			String currentRev = reverse.pop();
			
			if(!currentStr.equals(currentRev)) {
				System.out.println(str+" is NOT palindrome!");
				return false; //returns as soon as it realizes it is not a palindrome
			} 			
		}
		
		System.out.println(str+" IS a palindrome!");
		return true;

	}
}

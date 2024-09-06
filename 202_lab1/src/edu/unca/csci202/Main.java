package edu.unca.csci202;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int totalSum = 0;
		int numInt = 0;
		double avgNum;
		Scanner sc = new Scanner(System.in);
		String list = "The numbers are: ";
		String avg = "The average is: ";
		for(int i = 1; i<11; i++) {
			System.out.print("Enter integer "+i+": ");
			String num = sc.nextLine();
			try{
				numInt = Integer.parseInt(num);
				totalSum += numInt;
				if(i<10) {
					list += numInt + ", ";
				}else{
					list += numInt;
				}
			}catch (NumberFormatException e){ 
				System.out.println("Invalid integer.");
				i-=1;
			}
		}
		avgNum = totalSum*0.1;
		avg += avgNum;
		System.out.println(list);
		System.out.println(avg);
		
	}

}

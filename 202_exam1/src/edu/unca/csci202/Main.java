/*
 * Exam 1 Main class
 * 
 * 02/03/24
 * 
 * Josie Anderson
 */
package edu.unca.csci202;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	

	public static void main(String[] args) throws InputMismatchException, FileNotFoundException {
		Scanner scanIn = new Scanner(System.in);
	
		System.out.print("Please input filename: ");
		while(true){
			String filename = scanIn.nextLine();
			
			System.out.println("searching for " + filename);
			PPMImage image;
			
			try {
				image = new PPMImage(filename);
				
				System.out.print("Would you like to rotate the image? (y/n) ");
				String rotate = scanIn.nextLine();
				while(rotate.equals("y")) {
					image.rotate();
					
					System.out.print("Would you like to rotate the image again? (y/n) ");
					rotate = scanIn.nextLine();
				}
				
				System.out.println("Enter an output filename: ");
				String fileout = scanIn.nextLine();
				try {
					image.write(fileout);
					System.out.println("Successfully written");	
			
				} catch (FileNotFoundException e) {
					System.out.println("Not a valid file.");
				}
				break;
				
			} catch (FileNotFoundException e) {
	//			e.printStackTrace();
				System.out.println("Error: file not found.");
			} catch (InputMismatchException e) {
	//			ee.printStackTrace();
				System.out.println("Error: wrong file type, not PPM.");
			}
		
		}
	}
}

package edu.unca.csci201;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Lab2: demonstrate MathVector class for working with arrays and loops
 * 
 * Josie Anderson
 */
public class Main {

	public static double[] readData(String filename) throws FileNotFoundException {
		
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		int lineNumber = 0;
		while (scan.hasNextLine()){
		// Store each line of the text file into the array
			String temp = scan.nextLine();
			lineNumber++;
//			System.out.println("line " + lineNumber);
		}
		
		Scanner scan2 = new Scanner (file);
		double[] data = new double[lineNumber];
		for (int i=0; i< lineNumber; i++) {
			String temp = scan2.nextLine();
//			System.out.println(temp);
			data[i] = Double.parseDouble(temp);
		}
		return data;
	}
	
	public static void printArray(double[] array) {
		//complete this method
		for (int i=0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// read data files into arrays first
		double[] data1 = readData("file1.txt");
		double[] data2 = readData("file2.txt");
		double[] data3 = readData("file3.txt");
		
		printArray(data1); //3.0, 2.0, 7.0
		printArray(data2); //1.0, 4.4, 8.0, 3.0
		printArray(data3); //-9.0, 0.8, 5.0
		
		//construct MathVector objects from arrays
		MathVector v1 = new MathVector(data1);
		MathVector v2 = new MathVector(data2);
		MathVector v3 = new MathVector(data3);
		int v1Length = v1.numberOfElements();
		System.out.println("v1Length="+v1Length);//v1Length=3
		double v2Norm2 = v2.norm2();
		System.out.println("v2.norm2(): "+v2Norm2);//v2.norm2(): 9.66229786334493
		System.out.println("v3: "+v3); //v3: [-9.0, 0.8, 5.0]
		
		//modifying array shouldn't affect the MathVectors!
		data3[0]=-999;
		System.out.println("v3: "+v3); //v3: [-9.0, 0.8, 5.0]
		
		// draw a memory diagram of the state at this point
	}

}

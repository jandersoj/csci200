/*
 * Exam 1 PPMImage class
 * 
 * 02/03/24
 * 
 * Josie Anderson
 */
package edu.unca.csci202;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PPMImage {
	Pixel[][] pixelArr; //height/columns
	String pixels; //I should say that I wasn't going to do it this way until Jamie mentioned it - credit where due and whatnot
	
	public PPMImage(String filename) throws FileNotFoundException{
		
		boolean inputError = false; //throws the wrong file type exception
		int height; 
		int width; 
		int pixelMax = 255; 
		
		try {
			File file = new File(filename+".ppm");
			Scanner scan = new Scanner(file);
				
			if (!scan.nextLine().equals("P3")) {
				inputError = true;
			}
			
			if(scan.hasNextInt()) {
				width = scan.nextInt();
			} else {
				inputError = true;
				width = 0;
			}
			
			if(scan.hasNextInt()) {
				height = scan.nextInt();
			} else {
				inputError = true;
				height = 0;
			}
			
			if(scan.hasNextInt()) {
				pixelMax = scan.nextInt();
			}
			 
			System.out.println("Width: "+width+", Height: "+height);	 //TEST
			System.out.println("Pixel max value: "+pixelMax);

			pixelArr= new Pixel[height][width];

			while(scan.hasNext() && !inputError) {
				String nextLn = scan.nextLine();
				if(nextLn.startsWith("#")) {
					continue;
				} else {
					pixels += nextLn;
				}
			}
			
			scan.close();
			
			Scanner string_scan = new Scanner(pixels);
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					int red = string_scan.nextInt();
					int green = string_scan.nextInt();
					int blue = string_scan.nextInt();
					pixelArr[i][j] = new Pixel(red, green, blue);
					System.out.println(pixelArr[i][j].toString());
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		if(inputError) {
			throw new InputMismatchException();
		}
	}
	
		
	public  void rotate() {
		int tempHeight = pixelArr[0].length;
		int tempWidth = pixelArr.length;
		Pixel[][] rotated = new Pixel[tempHeight][tempWidth];
		String newPixels = "";
		
		for(int i = 0; i < tempHeight; i++) {
			for(int j = 0; j < tempWidth; j++) {
				int temp = tempWidth - 1 - j;
				rotated[i][j] = pixelArr[temp][i];
				
				newPixels += rotated[i][j].toString();
			}
		}
		pixels = newPixels;
		pixelArr = rotated;
	}
	
	public void write(String filename) throws FileNotFoundException { //talked to jamie about this one
		PrintWriter fileOut = new PrintWriter(filename);
		fileOut.append("P3\n");		
		fileOut.append(pixelArr.length+" "+pixelArr[0].length+"\n");		
		fileOut.append("255\n");	
		
		Scanner string_scan = new Scanner(pixels);
		fileOut.append(pixels);
		
		fileOut.close();
			
	}
	
	
}

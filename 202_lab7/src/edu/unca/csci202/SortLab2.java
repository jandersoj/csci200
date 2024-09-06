package edu.unca.csci202;
import java.util.Arrays;
import java.util.Random;

public class SortLab2 {

	public static void main(String[] args) {
		String arr[] = generateArray(5, 3, 9);
		
		String copy1[] = arr;
		Arrays.sort(copy1);
		System.out.println("\nArray sorted:");
		printArr(copy1);
		
		String copy2[] = arr;
		Sorting.quickSort(copy2);
		System.out.println("\nQuick sorted:");
		printArr(copy2);
		
		String copy3[] = arr;
		Sorting.selectionSort(copy3);
		System.out.println("\nSelection sorted:");
		printArr(copy3);
		
	}

	
	public static <T> void printArr(T[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.printf("[%s]", array[i]);
		}
		System.out.println();
	}
	
	public static String[] generateArray(int n, int minLength, int maxLength) {
		char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Random rand = new Random();
		String arr[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			int strLength = rand.nextInt(maxLength-minLength+1) + minLength;
			String str = "";	
			for(int j = 0; j < strLength; j++) {
				int index = rand.nextInt(26); //if letters[] was a param. i would add a loop to find length, but for now  I know how long the alphabet is.
				str += letters[index];
			}
			System.out.printf("[%s]", str);
			arr[i] = str;
		}
		
		System.out.println();
		return arr;
	}
		
}
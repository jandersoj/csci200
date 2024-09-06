package edu.unca.csci202;
import java.util.*;

public class SortLab {
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
		
	static int arr[];
			
	public static void main(String[] args) {
		
//		int choice = getChoice();
		int length = getSize();
		int[] array = makeArray(length);

		bubbleSort(array);
		printArray(array);
	}
	
	
	public static void bubbleSort(int[] array) {
	
	int count = 1;
		while(count > 0) {
			count = 0;
			for(int i=0; i < array.length-1; i++) {
				if(array[i] > array[i+1]) {
					swap(array, i+1, i);
					count ++;
				}

			}
			printArray(array);
		}
	}
	
	public static void swap(int array[], int data1, int data2) {
		int saved = array[data1];
		array[data1] = array[data2];
		array[data2] = saved;
	}
	
	public static int getChoice() {
		System.out.println("Enter a sorting algorithm (“selection”, “insertion”, or “bubble”) to sort an array: ");
		String answer = sc.nextLine();
		int choice = 0;
		
		if(answer == "selection")
			choice = 1;
		if(answer == "insertion")
			choice = 2;
		if(answer == "bubble")
			choice = 3;
		
		return choice;
	}
	
	public static int getSize() {
		System.out.println("Enter (in integer form) the length of your array to be sorted: ");
		int length = sc.nextInt();
		
		return length;
	}

	public static int[] makeArray(int size) {
		arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			int random = rand.nextInt(100);
			arr[i] = random;
		}
		printArray(arr);
		return arr;
	}
	
	public static void printArray(int[] vals) {
		for(int i = 0; i<vals.length; i++) {
			System.out.print(vals[i]+ " ");
		}
	System.out.println( );
	}
}

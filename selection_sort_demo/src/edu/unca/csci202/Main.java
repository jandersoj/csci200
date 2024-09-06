package edu.unca.csci202;

public class Main {

	// find the index of the smallest element starting at
	// startIndex and later
	public static int getIndexOfSmallest(int[] nums,int startIndex) {
		int indexOfSmallest=startIndex;
		for (int i=startIndex+1; i<nums.length; i++) {
			if (nums[i]<nums[indexOfSmallest]) {
				indexOfSmallest=i;
			}
		}
		return indexOfSmallest;
	}
	
	public static void selectionSort(int[] numbers) {
		for (int i=0; i<(numbers.length-1); i++) {
			
			int indexOfSmallest = getIndexOfSmallest(numbers,i);
			swap(numbers,i,indexOfSmallest);
		}
	}
	
	public static void swap(int[] vals,int index1, int index2) {
		int temp = vals[index1];
		vals[index1]=vals[index2];
		vals[index2]=temp;
	}
	
	public static void printArray(int[] values) {
		for (int i=0; i<values.length; i++) {
			System.out.println(values[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {3,9,6,1,2};
		printArray(nums);
		selectionSort(nums);
		System.out.println("sorted:");
		printArray(nums);

	}

}

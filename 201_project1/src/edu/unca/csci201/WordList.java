package edu.unca.csci201;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordList {
//		alright here we are making any file i so choose into an array what a nice method
	public static String[] readData(String filename) throws FileNotFoundException {	
		Scanner fileScan = new Scanner(new File(filename));
		int lineCt=0;
		while (fileScan.hasNext()) {
			fileScan.nextLine();
			lineCt++;
		}
//		System.out.println("number of lines=" + lineCt);
		
		String[] data = new String[lineCt];
		fileScan = new Scanner(new File(filename));
		int count=0;
		while (fileScan.hasNext()) {
			data[count]= fileScan.nextLine();
			count++;
		}
//		for (int i=0; i<data.length; i++) {
//			System.out.println(data[i]);
//		}
		return data;
	}
	
	public static int size() throws FileNotFoundException {
//		im not rly sure why it wants this throws thing in here but it is insisting so i just kept adding it
		String[] wordList = readData("wordlist.txt");
		int size = wordList.length;
		return size;
	}
		
	public static String getWord(int index) throws FileNotFoundException {
		String[] wordList = readData("wordlist.txt");
		String getWord = wordList[index];
		return getWord;
	}
	
	public static boolean inList(String word) throws FileNotFoundException {
		String[] wordList = readData("wordlist.txt");
		for(int i=0; i<size(); i++) {
			if (wordList[i] == word) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(size());
		System.out.println(getWord(11444));
		System.out.println(inList("apple"));
	}
	
//	still need to add the boolean one
	
}	



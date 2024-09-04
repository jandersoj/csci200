package file_read_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadDemo {

	public static void main(String[] args) throws FileNotFoundException {
		String url;
		Scanner fileScan, urlScan;

		fileScan = new Scanner(new File("websites.inp"));
		// count the lines first
		int lineCount=0;
		while (fileScan.hasNext()) {
			fileScan.nextLine();
			lineCount++;
		}
		System.out.println("number of lines="+lineCount);
		
		//store each line as an element in a String[]
		String[] lines = new String[lineCount];
		fileScan = new Scanner(new File("websites.inp"));
		int count=0;
		while (fileScan.hasNext()) {
			lines[count]= fileScan.nextLine();
			count++;
		}
		for (int i=0; i<lines.length; i++) {
			System.out.println("line: "+lines[i]);
		}
		
//		//fileScan = new Scanner(new File("C:\\Users\\NH008s\\Desktop\\websites.inp"));
//		
//		// Read and process each line of the file
//		while (fileScan.hasNext())
//		{
//			url = fileScan.nextLine();
//			System.out.println("URL: " + url);
//			urlScan = new Scanner(url);
//			urlScan.useDelimiter("/");
//
//			//  Print each part of the url
//			while (urlScan.hasNext())
//				System.out.println("   " + urlScan.next());
//
//			System.out.println();
//		}
	}

}

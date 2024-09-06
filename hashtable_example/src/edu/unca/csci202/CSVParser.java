package edu.unca.csci202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * class to parse a csv file from a url
 * assumes the first row is a header
 * iterator returns a map for each row, containing header:value pairs
 * 
 * @author ksanft
 *
 */
public class CSVParser implements Iterator<Map<String,String>> {

	private String[] headers; // column names
	private String[][] data;
	private int position;// current row number for iterator
	
	public static void main(String[] args) {
		String urlString1 = "https://www.cs.unca.edu/~ksanft/Most Common Last Names in the US.csv";
		String urlString2 = "https://www.cs.unca.edu/~ksanft/Most Common First Names in the US.csv";
		
		/*
		 * at first, don't do this...try to debug...by reading a different web page
		 */
//		urlString1 = urlString1.replace(" ", "%20");
//		urlString2 = urlString2.replace(" ", "%20");
//		
//		String fileData="";
//		
//		try {
//			//URL url = new URL(urlString1);
//			//URL url = new URL(urlString2);
//			
//			// read file from url
//			// file is text, so use BufferedReader
//			// to debug, try a different url:
//			//BufferedReader reader = new BufferedReader( new InputStreamReader(new URL("www.google.com").openStream()));
//			// need protocol:
//			//BufferedReader reader = new BufferedReader( new InputStreamReader(new URL("http://www.google.com").openStream()));
//			// when url string is fixed:
//			BufferedReader reader = new BufferedReader( new InputStreamReader(url.openStream()));
//			
//			String line;
//			//seems to automatically handle \r\n (?)
//	        while ((line = reader.readLine()) != null) {
//	            //System.out.println(line);
//	            fileData+=line+"\n";
//	        }
//	        reader.close();
//	        System.out.println(fileData);
//	        
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			//CSVParser csvData = new CSVParser(urlString1);
			CSVParser csvData = new CSVParser(urlString2);
			while (csvData.hasNext()) {
				System.out.println(csvData.next());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CSVParser(String url) throws MalformedURLException, IOException {
		String fileData = getFile(url);
		String[] lines = fileData.split("\\n");
		// data will have as many entries as lines, minus the header row
		data = new String[lines.length-1][];
		// headers is the first line
		headers=lines[0].split(",");
		for (int i=0; i<data.length; i++) {
			//System.out.println(i+": "+lines[i]);
			// this works for last name csv file
			// but others have quotes and commas in the data
			//data[i]=lines[i+1].split(",");
			// just use the first column...real solution would tokenize lines...
			data[i] = new String[1];
			data[i][0]=lines[i+1].split(",")[0];
		}
//		for (int i=0; i<data.length; i++) {
//			for (int j=0; j<data[i].length; j++) {
//				System.out.print(data[i][j]+"--");
//			}
//			System.out.println();
//		}
		position=0;
	}
	
	private String getFile(String url) throws MalformedURLException, IOException {
		url=url.replace(" ", "%20");
		String fileData="";
		
		// read file from url
		// file is text, so use BufferedReader
		BufferedReader reader = new BufferedReader( new InputStreamReader(new URL(url).openStream()));

		String line;
		//seems to automatically handle \r\n (?)
		while ((line = reader.readLine()) != null) {
			//System.out.println(line);
			fileData+=line+"\n";
		}
		reader.close();
		return fileData;
		
	}
	
	@Override
	public boolean hasNext() {
		return position < data.length;
	}

	@Override
	public Map<String, String> next() {
		TreeMap<String,String> map = new TreeMap<String,String>();
		for (int i=0; i<data[position].length; i++) {
			map.put(headers[i], data[position][i]);
		}
		position++;
		return map;
	}
	
	/**
	 * Number of rows
	 * 
	 * @return the number of rows (not including header)
	 */
	public int numRows() {
		return data.length;
	}
}

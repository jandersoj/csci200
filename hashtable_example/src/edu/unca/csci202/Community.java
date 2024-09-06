package edu.unca.csci202;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;

/**
 * A class to hold a hash table of Person objects
 * where the key is the Person's userid
 * hash table will use chaining via a LinkedList
 * 
 * @author ksanft
 *
 */
public class Community { //implements Map<String, Person> //implements Set<Person>

	protected LinkedList<Person>[] bins;
	protected int size; // number of person objects in bins
	
	public static void main(String[] args) {
//		Person p1 = new Person("Kevin","Sanft");
//		System.out.println(p1);
//		Person p2 = new Person("Becky","Sanft");
//		System.out.println(p2);
//		Person p3 = new Person("","Sanft");
//		System.out.println(p3);
//		
//		Community c = new Community(8);
//		c.add(p1);
//		c.add(p2);
//		c.add(p3);
//		System.out.println(c);

		String urlString1 = "https://www.cs.unca.edu/~ksanft/Most Common Last Names in the US.csv";
		String urlString2 = "https://www.cs.unca.edu/~ksanft/Most Common First Names in the US.csv";

		try {
			CSVParser lastData = new CSVParser(urlString1);
			CSVParser firstData = new CSVParser(urlString2);
			
			String[] lastNames = new String[lastData.numRows()];
			String[] firstNames = new String[firstData.numRows()];
			
			int row=0;
			while (lastData.hasNext()) {
				lastNames[row++]=lastData.next().get("Name");
			}
			row=0;
			while (firstData.hasNext()) {
				firstNames[row++]=firstData.next().get("Name");
			}
//			System.out.println(Arrays.toString(lastNames));
//			System.out.println(Arrays.toString(firstNames));
			
			Community c = new Community(8);
			// generate some random Persons
			Random rand = new Random(123);
			for (int i=0; i<10; i++) {
				String last=lastNames[rand.nextInt(lastNames.length)];
				String first="";
				first=firstNames[rand.nextInt(firstNames.length)];
				c.add(new Person(first,last));
			}
			System.out.println(c);
			
			// print counts of how many bins have different numbers of elements
			// if all bins had 0 or 1 entries, that would mean no collisions occurred
			c.collisionReport();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// test unique userId code:
//		Community c = new Community(8);
//		Person p1 = new Person("John","Doe",c);
//		c.add(p1);
//		Person p2 = new Person("Jane","Doe",c);
//		c.add(p2);
//		Person p3 = new Person("Judy","Doe",c);
//		c.add(p3);
//		Person p4 = new Person("Joan","Doe",c);
//		c.add(p4);
//		System.out.println(c);
	}
	
	/**
	 * Constructor
	 * @param numberOfBins is the size of the underlying array
	 */
	public Community(int numberOfBins) {
		bins = (LinkedList<Person>[]) new LinkedList<?>[numberOfBins]; // strange syntax!
		// initialize all the linked lists
		for (int i=0; i<numberOfBins; i++) {
			bins[i] = new LinkedList<Person>();
		}
		size=0;
	}

	/**
	 * Insert a person into the Community
	 * 
	 * @param p the Person to be added
	 * @return true if Community did not already contain this Person
	 */
	public boolean add(Person p) {
		// find which bin to hash to
		System.out.println("adding "+p);
		System.out.println("p.getUserId().hashCode(): "+p.getUserId().hashCode());
		int index = Math.abs(p.getUserId().hashCode()) % bins.length;
		System.out.println("index: "+index);
		// see if this Person is already in this bin's LinkedList:
		if (bins[index].contains(p)) {
			return false;
		}
		bins[index].add(p);
		return true;
	}
	
	/**
	 * see if key (Person's userId) is in our hash table
	 * @param key (userId)
	 * @return true if found
	 */
	public boolean containsKey(String key) {
		// find the bin
		int index = Math.abs(key.hashCode()) % bins.length;
		// see if a person with this userid is in the linked list
		for (int i=0; i<bins[index].size(); i++) {
			if (bins[index].get(i).getUserId().equals(key)) {
				return true;
			}
		}
		return false; 
	}
	
	public String toString() {
		String out="";
		for (int i=0; i<bins.length; i++) {
			out+=i+": ";
			for (int j=0; j<bins[i].size(); j++) {
				out+=bins[i].get(j).getUserId()+", ";
			}
			out+="\n";
		}
		return out;
	}
	
	/**
	 * print out a table of number of bins with i entries
	 * i>1 means a collision occurred
	 */
	public void collisionReport() {
		TreeMap<Integer,Integer> stats = new TreeMap<Integer,Integer>();
		for (int i=0; i<bins.length; i++) {
			int size = bins[i].size();
			if (stats.containsKey(size)) {
				int count = stats.get(size) + 1;
				stats.put(size,count);
			} else {
				stats.put(size, 1);
			}
		}
		System.out.println("entries\t\t# of bins");
		for(Integer i = stats.firstKey(); i != null ; i = stats.higherKey(i) ) {
			System.out.println("      "+i+"\t\t\t"+stats.get(i));
		}
	}
}

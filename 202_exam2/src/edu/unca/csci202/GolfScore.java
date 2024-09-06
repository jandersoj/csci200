package edu.unca.csci202;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GolfScore implements Comparable<GolfScore> {

	// DO NOT MODIFY INSTANCE VARIABLES
	private LocalDate date;
	private int par;
	private int score;
	
	// DO NOT MODIFY CONSTRUCTOR
	public GolfScore(LocalDate date, int par, int score) {
		this.date=date;
		this.par=par;
		this.score=score;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public int getDifferential() {
		//the difference between score and par as an int
		int diff = par - score;
		return diff;

	}

	public String toString() {
		int diff = getDifferential();
		String out = "";
				
		// date formatting code provided, format date as usual month/day/year (m/d/yyyy)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/YYYY");
		out += formatter.format(date);
		out += " "+score+" (";
		
		if(diff == 0) {
			out += "E)";
		} else if(diff > 0) {
			out += "+"+diff+")";
		} else {
			out += diff+")";
		}
		
		return out;
	}

	public boolean equals(GolfScore other) {
		//I think this is just supposed to return if the differential is the same??
		int diff1 = getDifferential();
		int diff2 = other.getDifferential();
		
		if(diff1 == diff2) {
			return true;
		}
		
		return false;
	}

	public int compareTo(GolfScore other) {

		int diff1 = getDifferential();
		int diff2 = other.getDifferential();
		
		return (diff1 - diff2); //and this should return 0 if they're the same, just like .equals().
	}

}

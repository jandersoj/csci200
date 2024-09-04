package edu.unca.csci201;

public class Board {
	
	Column[] Board = new Column[6];
	
	public boolean insert(Disk disk, int columnIndex) {
		//needs to take the insert method in Column.java and put the disk in there
		//get into the column at columnIndex and insert there
		if(Board[columnIndex].full() == false) {
			Board[columnIndex].insert(disk);
			return true;
		} else return false;  
	}
	
	public String toString() {
		String result = null;
		int r;
		int c;
 
		for(r=6; r>=0; r--) {
			result +="|";
			//then in each of these it will iterate over that index in all the columns. so it will be at Board[column]
			//and then we can use the get(int rowIndex)
			for(c=0; c<7; c++) {
				result += " " + Board[c].get(r).color + " |" ;
			}
			//really not sure how i'm doing with the concatenation here--i'm trying to run a println in main 
			//but it says there's nothing to run??
			
			//need to make something here for the nulls. if it's null it needs to just be a space but idk how to do that rn
		}
		return result;
		
//	It should return a String object that, when printed, looks like the gameboard we see during the	gameplay.
//	Hint: this should include a nested loop where the outer loop iterates from the top row to the
//	bottom row and the inner loop iterates over the Columns.
	}	
}

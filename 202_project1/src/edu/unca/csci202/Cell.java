/**
 * Project1 - Cell class
 * 
 * 02/11/2024
 * 
 * Josie Anderson
 * 
 */

package edu.unca.csci202;

public class Cell {

	String status; //String for the cell status always visible to the player, showing their guesses
	String peekStatus; //string for the cell status for the "peek" version of the board, showing both their guesses and all of the mines.
	
	/**
	 * the constructor for the cell before mines are placed, automatically sets everything to "-"
	 */
	public Cell() {
		status = "-";
		peekStatus = "-";	
	}


	//do I need to do javadocs for these?
	protected String getPeekStatus() {
		return peekStatus;
	}
	
	protected String getStatus() {
		return status;
	}
	
	protected void setPeekStatus(String peekStatus) {
		this.peekStatus = peekStatus;
	}

	protected void setStatus(String status) {
		this.status = status;
	}
	
	
}

/**
 * Project1 - Gameboard class
 * 
 * 02/11/2024
 * 
 * Josie Anderson
 * 
 */

package edu.unca.csci202;
//import java.io.InputStream;
import java.util.*;

public class Gameboard {

	public Cell[][] board;
	int minesFound;
	String question; //used in a few different methods to pull y/n responses
	boolean gameOver;
	Scanner scan;
	
	/**
	 * The constructor, creates a board and instantiates each cell.
	 */
	public Gameboard() {
		scan = new Scanner(System.in);
		board = new Cell[8][8];
		
		for (int i = 0; i < 8; i++) { 
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Cell(j, i); //cell status is automatically '-'
			}
		}
		minesFound = 0;  	
	}
	
	/**
	 * facilitates the playing of multiple games (starts and ends them)
	 */
	public void run(){
		int gamesPlayed = 0;
		gameOver = false;		
		
		System.out.println("Welcome to Minesweeper!"); //the first game
		
		question = getResponse("Would you like to play a game? (y/n): ", 1);
		
		if (question.equals("y")) {
			playGame();
			gamesPlayed++;
		} else if(question.equals("n")) {
			System.out.println("Goodbye!");
		}
		
		while(gamesPlayed > 0) { //after the first game
			System.out.println("Thank you for playing Minesweeper.");
			question = getResponse("Would you like to play again? (y/n): ", 1);
			if(question.equals("y")) {
				playGame();
				gamesPlayed++;
			}else{ 
				System.out.println("Goodbye!");
				break;
			}
		}
	}
	
	/**
	 * technically this just plays a bunch of turns over and over while gameOver == false, but isn't that what a game is?
	 */
	public void playGame() {
		int guessRow, guessCol;
		gameOver = false;
		
		clearBoard(board);
		setMines(board);
		
		while(gameOver == false){ //once one of the later guesses sends a game over, the loop stops.
			
			question = getResponse("Would you like to peek? (y/n): ", 1);
			if(question.equals("y")) {
				printBoard(board); //prints the board with all mines, etc. visible--the 'peek' version.
			}
			
			guessRow = Integer.parseInt(getResponse("Please enter a row number: ", 0));
			guessRow -= 1;//the -1 here accounts for the array index
			guessCol = Integer.parseInt(getResponse("Please enter a column number: ", 0)); //parses it back from the string output to a nice int
			guessCol -= 1;
			
			question = getResponse("Does row "+(guessRow+1)+" and column "+(guessCol+1)+" contain a mine? (y/n): ", 1);	
			if (question.equals("y")) {
				guessMine(board, guessRow, guessCol);
			} else if (question.equals("n")){
				guessEmpty(board, guessRow, guessCol);
			}	
		}
	}
	
	/**
	 * 
	 * @param int input - takes 0 to get the row or column guess from the player, or takes 1 to get a yes/no answer.
	 * @return int intEntry - returns the player's guess
	 */
	public String getResponse(String message, int input) {
		String errorMessage = "Invalid input, please try again.";
		int intEntry = -1;
		String entry = "";
		
		System.out.print(message);
		
		if(input == 0) { //a 0 input means it's asking for an int
			while(true) {
				entry = scan.nextLine();
				
				try { //parses the integer entered and checks to make sure it's valid
					intEntry = Integer.parseInt(entry);
					if(intEntry <= 8 && intEntry >= 1) {
						return intEntry + "";
					} else { //prints an error if the int entered is not within bounds of the board
						System.out.println(errorMessage);
						System.out.print(message);
						entry = scan.nextLine();
					}
				} catch(Exception e) { //catches any other errors
					System.out.println(errorMessage);
					System.out.print(message);				
				}
			}
			
		} else if(input == 1) { //a 1 input is asking for a y/n
			while(true) {
				entry = scan.nextLine();
				
				if (entry.equals("y") || entry.equals("n")) {
					return entry; //as long as the answer is valid it returns it
				} else {//if it is not valid, it prints the error and then asks the question again.
					System.out.println(errorMessage);
					System.out.print(message);
				}
			}
		}
		return ""; //if for some reason no answer has been pulled
	}
	
	/**
	 * 
	 * @param Cell[][] board - takes the entire board to guess if there is a mine in a certain spot
	 * @param int col - which column the guess is in
	 * @param int row - which row the guess is in
	 */
	public void guessMine(Cell[][] board, int col, int row) { //i know they're technically switched here from the input. I don't know why this is what works. 

		if (board[col][row].peekStatus == "M"){//if there is a mine there
//			System.out.println("Correct!");
			board[col][row].setStatus("M");//make the visible status show "M"
			printPlayerBoard(board);
			minesFound++;
			if(minesFound == 10) { //once ten mines have been found, the game is over
				System.out.println("You win!");
				gameOver = true;
			}
			
		} else {
			System.out.println("Boom! You lose.");
			gameOver = true;
			
		}
	}
	
	
	/**
	 * 
	 * @param Cell[][] board - the same as above but to guess that it is empty
	 * @param int col - see above
	 * @param int row - see above
	 */
	public void guessEmpty(Cell[][] board, int col, int row) { //I don't know why col and row are backwards here too but if it works, it works.

		
		if (board[col][row].getPeekStatus().equals("M")){ //if you guessed wrong, you lode.
			System.out.println("Boom! You lose.");
			gameOver = true;
		}else{
			String result = getTouching(col, row)+"";
			if(result.equals("0")) {
				expand(col, row);
			}
			
		}
		printPlayerBoard(board); 

	}
	
	public int getTouching(int col, int row) {
		int count = 0; //how many mines are in the 8 adjacent cells to the guess
		String countStr = "0"; //the string version of count to be shown in the printed board.
//		I couldn't really think of a way to make a loop work better here
		if(row > 0 && board[col][row-1].getPeekStatus().equals("M")) // top middle side
			count++;
		if(row < 7 && board[col][row+1].getPeekStatus().equals("M")) // bottom middle side
			count++;
		if(row > 0 && col > 0 && board[col-1][row-1].getPeekStatus().equals("M")) // upper left corner
			count++;
		if(col > 0 && board[col-1][row].getPeekStatus().equals("M")) // middle left side
			count++;
		if(row < 7 && col > 0 && board[col-1][row+1].getPeekStatus().equals("M")) // bottom left corner
			count++;
		if(row > 0 && col < 7 && board[col+1][row-1].getPeekStatus().equals("M")) // top right corner
			count++;
		if(col < 7 && board[col+1][row].getPeekStatus().equals("M")) // middle right side
			count++;
		if(row < 7 && col < 7 && board[col+1][row+1].getPeekStatus().equals("M")) // bottom right corner
			count++;
		
		countStr = count+""; //turns the count into a string
		
		board[col][row].setStatus(countStr); //sets the status of both the cell on the board always visible to the player 
		board[col][row].setPeekStatus(countStr); //and the 'peek' version to the number of adjacent mines
		
		return count;
	}
	
	public void expand(int col, int row) {
		
		
		ArrayStack<Cell> stack = new ArrayStack();
		Cell currCell = board[col][row]; //original cell
		
		stack.push(currCell);
		getTouching(col, row);
		currCell.setVisited(true);
		
		while(!stack.isEmpty()){
			
			currCell = stack.pop();
			row = currCell.getRow();
			col = currCell.getCol();
			
			for(int i = -1; i < 2; i++) {
				for(int j = -1; j < 2; j++) {
//					try {
						
						int newRow = row + i;
						int newCol = col + j;
						
						while (newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7
								&& !board[newCol][newRow].isVisited()) {
							int mines = getTouching(newCol, newRow);
							currCell = board[newCol][newRow];
							currCell.setVisited(true);
							if(mines == 0) {
								stack.push(currCell);
							} else {
								break;
							}
						}
//					} catch(ArrayIndexOutOfBoundsException e) {
//	                   System.out.println("array index out of bounds exception");
//	                   break;
//					}
				}
//			System.out.println("cuttent stack: "+ stack.toString());
//			currCell = null;
			}
		}
	}
	
	/**
	 * 
	 * @param board - takes in the board to set 10 mines in 10 random cells.
	 */
	public void setMines(Cell[][] board) {
		Random rand = new Random();
		int randOne;
		int randTwo;
		
		int i = 0;
		while(i < 10) { //places a mine if the random spot is empty--or '-'. 
			randOne = rand.nextInt(8); //picks new x and y every time.
			randTwo = rand.nextInt(8);	
			
			if(board[randTwo][randOne].getPeekStatus() == "-") {//it only places and i++-es if it is not already a mine!
				board[randTwo][randOne].setPeekStatus("M");
				i++;			
			}
		}
	}
	
	
	/**
	 * 
	 * @param board - takes in a board and prints it in it's "peek" status--showing all mines
	 */
	public void printBoard(Cell[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j].peekStatus + " ");
			}
			System.out.println();
		}
		System.out.println();
	}	
	
	
	/**
	 * 
	 * @param board - takes in a board and prints it's current visible status, hiding unguessed mines
	 */
	public void printPlayerBoard(Cell[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j].status + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	/**
	 * 
	 * @param board - takes a board and sets all of the cell statuses to '-', 'clearing' it to set 10 new random mines.
	 */
	public void clearBoard(Cell[][] board) {
		minesFound = 0; //also clears how many mines have been found so far this game.
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j].status = "-"; //cell status is set to '-'
				board[i][j].peekStatus = "-";
			}
		}
		printBoard(board);
	}

}

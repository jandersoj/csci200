package edu.unca.csci201;


public class Pawn extends ChessPiece {

	public Pawn(int color) {
		super(color);
		this.abbreviation = 'P';
	}

	public Pawn(int color, String position) {
		super(color, position);
		this.abbreviation = 'P';
	}

	public boolean validMove(String code) {
		boolean result;
		int c1 = code.charAt(0);
		int c2 = code.charAt(1);
		
		result = false;
		
		if(c1 >= 'a' && c1 <= 'h') {
			if(c2 >= '1' && c2 <= '8' ) {
				result = true;
			}	
		}	
		return result;
	}

}

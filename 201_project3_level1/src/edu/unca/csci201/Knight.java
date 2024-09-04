package edu.unca.csci201;

public class Knight extends ChessPiece {

	public Knight(int color) {
		super(color);
		this.abbreviation = 'N';
	}

	public Knight(int color, String position) {
		super(color, position);
		this.abbreviation = 'N';
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

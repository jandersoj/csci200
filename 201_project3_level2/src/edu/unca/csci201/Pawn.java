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
		boolean result = false;
		int c1 = code.charAt(0);
		int c2 = code.charAt(1);
		
		if(c1 >= 'a' && c1 <= 'h') {
			if(c2 >= '1' && c2 <= '8' ) {
				int row = Math.abs(7 - (code.charAt(1) - 49));
				int column = code.charAt(0) - 97;
				if(validMoveLvl2(row, column)) {
					result = true;
				}
			}	
		}	
		return result;
	}
	
	public boolean validMoveLvl2(int row, int column) {
		boolean result2 = false;
		String startingPos = this.getPosition();
//		System.out.println(startingPosition);
//		and here i'm going to use the parseCode
		int[] parsedCode = parseCode(startingPos);
		if (this.isWhite()) {
			if (row == parsedCode[1] + 1 && column == parsedCode[0]) {
				result2 = true;
			}
		} else {
			if (row == parsedCode[1] - 1 && column == parsedCode[0]) {
				result2 = true;
			}
		}
		return result2;	
	}
	
	public int[] parseCode(String code){
//		jamie told me about her parseCode method and i realized 
//		that was probably the best way to go about things
		int[] parsed = new int[2];
		char c1 = code.charAt(0);
		int column = c1-97;
		parsed[0] = column;
		
		String r = ""+code.charAt(1);
		int row = Integer.parseInt(r);
		parsed[1]=8-row;
		return parsed;
		
	}

}

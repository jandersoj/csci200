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
	
	public boolean validMoveLvl2(int column, int row){
		boolean result2 = false;
		String startingPos = this.getPosition();
		int[] parsedCode = parseCode(startingPos);
		
		if (Math.abs(parsedCode[0] - column) == 2 && Math.abs(parsedCode[1] - row) == 1) {
			result2 = true;
		} else if (Math.abs(parsedCode[0] - column) == 1 && Math.abs(parsedCode[1] - row) == 2) {
			result2 = true;
		}
		return result2;
	}
	
	public int[] parseCode(String code){
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

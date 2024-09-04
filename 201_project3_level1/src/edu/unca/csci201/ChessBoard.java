package edu.unca.csci201;

public class ChessBoard {
	private ChessPiece[][] board;
	
	public ChessBoard() {
		board = new ChessPiece[8][8];
	}
	
	public void place(ChessPiece piece, String code) {
		int x = code.charAt(0) - 97;
		int y = Math.abs(7 - (code.charAt(1) - 49));
		
		//now you might be asking, "josie what nonsense is this?? absolute value??" 
		//to which i will respond "well the array's upside down and i thought it would be a clever little fix. and it is."
				
		piece.setPosition(code);
		board[y][x] = piece;
	}
	
	// returns the captured ChessPiece or null
	public ChessPiece move(String codeStart, String codeEnd) throws IllegalMoveException {
		
		IllegalMoveException problem = new IllegalMoveException("Illegal move attempted >:(");

		int x1 = codeStart.charAt(0) - 97;
		int x2 = codeEnd.charAt(0) - 97;
		int y1 = Math.abs(7 - (codeStart.charAt(1) - 49));
		int y2 = Math.abs(7 - (codeEnd.charAt(1) - 49));
		ChessPiece captive = null;
		ChessPiece inPlay;
		
		if (x1 >= 8 || x1 < 0 || y1 >= 8 || y1 < 0) {
			throw problem;
		} else if (x2 >= 8 || x2 < 0 || y2 >= 8 || y2 < 0) {
			throw problem;
		}

		if(board[y1][x1].validMove(codeEnd) == false) {
			throw problem;
		}
		
		if(board[y2][x2] != null) {
			captive = board[y2][x2];
		}
		
		if(board[y1][x1] != null) {
			inPlay = board[y1][x1];
			board[y2][x2] = inPlay;
			board[y1][x1] = null;
		}
					
		if(captive != null) {
			return captive;
		}
		return null;
	}
			
	public String toString() {
		String out="    ";
		for (char c='a'; c<='h'; c++) {
			out+=c+"    ";
		}
		out+="\n ";
		
		for (int k=0; k<41; k++) {
			out+="-";
		}
		out+="\n";

		for (int i=0; i<board.length; i++) {
			out+=(8-i)+" | ";
			for (int j=0; j<board[i].length; j++) {
				ChessPiece piece = board[i][j];
				if (piece==null) {
					out+="  ";
				} else {
					out+=piece;
				}
				out+=" | ";
			}
			out+="\n ";
			for (int k=0; k<41; k++) {
				out+="-";
			}
			out+="\n";
		}
		return out;
	}
}

package edu.unca.csci201;

//test edit

public class Letter {
	char character;
	boolean bold;
	boolean italic;
	
	public Letter(char input) {
		character = input;
		bold = false;
		italic = false;
	}
	
	public Letter(String input) {
		character = input.charAt(0);
		bold = false;
		italic = false;
	}

	public char getChar() {
		return character;
	}

	public boolean isBold() {
		return bold;
	}

	public boolean isItalics() {
		return italic;
	}

	public String toString() {
		return "Letter [character=" + character + ", bold=" + bold + ", italic=" + italic + "]";
	}

	public void setBold() {
		bold = true;
	}
	
	public void unsetBold() {
		bold = false;
	}
	
	public void setItalics() {
		italic = true;
	}
	
	public void unsetItalics() {
		italic = false;
	}
	
	public void printHTML() {
		String boldStart = "<b>";
		String boldEnd = "</b>";
		String italicsStart = "<i>";
		String italicsEnd = "</i>";
		
		if(isBold() == false && isItalics() == false) {
			System.out.println(getChar());
		} else if (isBold() == true && isItalics() == false) {
			System.out.println(boldStart + getChar() + boldEnd);
		} else if (isBold() == false && isItalics() == true) {
			System.out.println(italicsStart + getChar() + italicsEnd);
		} else if (isBold() == true && isItalics() == true) {
			System.out.println(boldStart + italicsStart + getChar() + italicsEnd + boldEnd);
		}
	}


	
	
	
	
}

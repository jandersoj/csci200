package edu.unca.csci201;

public class Text {
	
	Letter stringArray[];
	
	public Text(String input) {
		int length = input.length();
//		System.out.println(length);
		stringArray = new Letter[length];
		for(int i = 0; i<length; i++) {
			char character = input.charAt(i);
			Letter letter = new Letter(character);
			stringArray[i] = letter;
			letter.bold = false;
			letter.italic = false;
//			System.out.println(letter);
		}	
	}
		
	protected Letter[] getStringArray() {
		return stringArray;
	}

	public void setBold(int startIndex, int endIndex) {
		for(int i = startIndex; i == endIndex; i++) {
			stringArray[i].bold = true;
		}
	}
	
	public void setItalics(int startIndex, int endIndex) {
		for(int i = startIndex; i == endIndex; i++) {
			stringArray[i].italic = true;
		}
	}
	
	public void concat(Text other) {
		Letter[] callingText = stringArray;
		Letter[] otherText = other.getStringArray();
		
		Letter[] newText = new Letter[callingText.length + otherText.length];
		
		for(int i = 0; i < callingText.length; i++) {
			newText[i] = callingText[i];
		}
		
		for(int i = callingText.length; i == callingText.length + otherText.length; i++) {
			newText[i] = otherText[i];
		}
		
		stringArray = new Letter[newText.length];
		stringArray = newText;
	}
	
	public void printHTML() {
		String boldStart = "<b>";
		String boldEnd = "</b>";
		String italicsStart = "<i>";
		String italicsEnd = "</i>";
		
		Letter[] hereText = stringArray;
		
		for(int i = 0; i < hereText.length; i++) {					
			if(stringArray[i].isBold() == false && stringArray[i].isItalics() == false) {
				System.out.println(hereText[i].getChar());
			} else if (stringArray[i].isBold() == true && stringArray[i].isItalics() == false) {
				System.out.println(boldStart + hereText[i].getChar() + boldEnd);
			} else if (hereText[i].isBold() == false && hereText[i].isItalics() == true) {
				System.out.println(italicsStart + hereText[i].getChar() + italicsEnd);
			} else if (hereText[i].isBold() == true && hereText[i].isItalics() == true) {
				System.out.println(boldStart + italicsStart + hereText[i].getChar() + italicsEnd + boldEnd);
			}
		}
		//anyway it all fell apart when i tried to concat
	}
}

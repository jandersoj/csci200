package edu.unca.csci201;

public class Disk {
	char color;
	public Disk(char Char) {
	    if(Char == 'R') {
	    	color = 'R';
	    }else if(Char == 'B') {
	    	color = 'B';
	    }
	  }
	
	public boolean isRed(){
		if (this.color == 'R') {
			return true;
		} else return false;			
	}
	
	public boolean isBlack(){
		if (this.color == 'B') {
			return true;
		} else return false;			
	}
	
}

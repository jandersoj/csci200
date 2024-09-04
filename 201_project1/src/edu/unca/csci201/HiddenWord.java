package edu.unca.csci201;

public class HiddenWord {

	public static String allCaps(String guess) {
		String allCaps = guess.toUpperCase();
		return allCaps;
	}
	
			
	public static String evaluateGuess(String allCaps) {
		String hiddenWord = "HONEY";
//		just for now this is here
//		ok going to do a nice counter with i here through the substrings of both the allCaps guess and the Hidden Word tm
//		think the move is to start from the most broad so we will set result[] to be {_,_,_,_,_} i think you can do it that way
//		and then if allCaps substring at i == hiddenWord substring at 1 (or 2, 3, 4, or 5) then make result[i] = Y
//		and theeennn if allCaps at i == hiddenWord at i then make result[i] = G. 
//		finally it'll return result[] as a string in this nice format
		char[] result = {'_','_','_','_','_'};
		for (int i=0; i<allCaps.length(); i++){
			
			for (int j=0; j<allCaps.length(); j++) {
			    if(allCaps.substring(i, i+1) == hiddenWord.substring(j,j+1)) {
			    	result[i] += 'Y';
			    }
			}
			if(allCaps.substring(i, i+1) == hiddenWord.substring(i, i+1)) {
				 result[i] += 'G';
			}   		  
		}
		
		String resultStr = new String(result);
		return resultStr;	 
	}
	public static void main(String[] args) {
		System.out.println(allCaps("jOsiE"));
		System.out.println(evaluateGuess("JOSIE"));
	}
//yeah ok its too late to keep this up there's no way I can finish this lol
//this code doesnt break or anything it just like sits there.
//again the vibes are ok like it seems ok so far and im proud of what ive done i just should have made time to start sooner.
}

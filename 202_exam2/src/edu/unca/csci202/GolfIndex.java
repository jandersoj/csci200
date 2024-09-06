package edu.unca.csci202;

import java.util.ArrayList;
import java.util.List;

public class GolfIndex {
	private int N; // keep N most recent scores
	private int M; // use best M scores (by differential) to compute "index"
	// INSERT ADDITIONAL INSTANCE VARIABLES HERE, IF NECESSARY

	protected List<GolfScore> scoreList;
			
	public GolfIndex(int N, int M) {
		this.N=N;
		this.M=M;
		// INITIALIZE ADDITIONAL INSTANCE VARIABLES HERE, IF NECESSARY
		scoreList = new ArrayList<GolfScore>(N);
		
//		for(int i = 0; i < N; i++) {
//			scoreList.set(i, new GolfScore());
//		}
	}

	// IMPLEMENT THIS METHOD
	//This should be O(n) in the worst case, having to shift everything over one.
	public void insertScore(GolfScore score) {
		//assuming that they are in order of date, and assuming that there are no duplicates.
		if(score != null) {
			scoreList.add(0,score);
		}
		
		if(scoreList.size() > N) {
			scoreList.remove(scoreList.size()-1);
		}
	}

	// IMPLEMENT THIS METHOD
	/**
	 * 
	 * @return a list of the lowest M scores (by differential) of the past N inserted scores
	 */
//	public List<GolfScore> getLowestM() {
//		 
//		List<GolfScore> test = scoreList;
//		
//		List<GolfScore> lowestM = new ArrayList<>(M);
//		
//		//if i had time i would put a for loop here finding the indices of the smallest diff and going up
//		//until my list M long was full
//		
//		//or that collection sort thing but idk how to use that well enough.
//		
//		return lowestM;
//	}
	
	// IMPLEMENT THIS METHOD
	/**
	 * 
	 * @return the average differential of the best
	 */
	public double computeIndex() {
		int count = 0;
		double total = 0.0;
		
		if(scoreList.size()==0) {
			return 0.0;
		}
		
		for(int i = 0; i < scoreList.size(); i++) {
			total += scoreList.get(i).getDifferential();
			count++;
		}
		return total / count;
	}
	
	public String toString() {
		String out = "";
		
		for(int i = 0; i < scoreList.size(); i++) {
			if(scoreList.get(i) == null) {
				break;
				
			}else {
				out += scoreList.get(i) + "\n";
			}
		}
		return out;
	}

}

/**
 * 
 */
package edu.unca.csci202;

/**
 * LargeInteger extends Comparable
 * 
 * @author jander15
 * @param <T>
 */
public interface LargeInteger extends Comparable<LargeInteger> {

	/** 
	 * adds a given LargeInteger and 'this', returns sum 
	 *
	 * @param num the LargeInteger to be added to 'this'
	 * @return the sum of the two
	 */
	LargeInteger add(LargeInteger num);
	
	/** 
	 * subtracts a given LargeInteger from 'this', returns difference 
	 *
	 * @param num the LargeInteger to be subtracted from 'this'
	 * @return the difference between the two
	 */
	LargeInteger subtract(LargeInteger num);

	/** 
	 * returns the negative value of the LargeInteger
	 *
	 * @return the negative value
	 */
	LargeInteger negate();
	
	/** 
	 * returns the absolute value of the LargeInteger
	 *
	 * @return the absolute value
	 */
	LargeInteger abs();
	
	/** 
	 * multiplies a given LargeInteger and 'this' 
	 *
	 * @param num the LargeInteger to be multiplied with 'this'
	 * @return the LargeInteger product of the two
	 */
	LargeInteger multiply(LargeInteger num);	
	
	/** 
	 * compares an input LargeInteger and this LargeInteger to find the larger 
	 *
	 * @param num the LargeInteger to be compared with this one
	 * @return the larger LargeInteger
	 */
	LargeInteger max(LargeInteger num);
	
	/** 
	 * compares an input LargeInteger and this LargeInteger to find the smaller 
	 *
	 * @param num the LargeInteger to be compared with this one
	 * @return the smaller LargeInteger
	 */
	LargeInteger min(LargeInteger num);

	/** 
	 * checks whether this LargeInteger is positive, negative, or zero.
	 *
	 * @return 0 if it's 0, 1 if it's positive, or -1 if it's negative.
	 */
	
	int signum();

}

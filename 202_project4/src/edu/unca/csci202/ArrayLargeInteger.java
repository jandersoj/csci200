package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayLargeInteger implements LargeInteger {

    public static final ArrayLargeInteger ZERO = new ArrayLargeInteger("0");
    public static final ArrayLargeInteger ONE = new ArrayLargeInteger("1");
    public static final ArrayLargeInteger TEN = new ArrayLargeInteger("10");

    private boolean isNegative;
    private ArrayList<Integer> digits;

    public ArrayLargeInteger(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("");
        }

        int initialIndex = 0;
        isNegative = false;

        if (input.charAt(0) == '-') {
            isNegative = true;
            initialIndex = 1;
        }

        digits = new ArrayList<Integer>();
        for (int i = initialIndex; i < input.length(); i++) {
            digits.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    public ArrayLargeInteger(ArrayLargeInteger input) {
        this.digits = input.digits;
        this.isNegative = input.isNegative;
    }

    public ArrayLargeInteger(boolean isNegative, ArrayList<Integer> digits) {
        this.isNegative = isNegative;
        this.digits = digits;
    }

    
    /**
     * Traverse through the list and carry over remainders to the next digit.
     */
    private void carryDigits() {
        for (int i = digits.size() - 1; i >= 0; i--) {
            final int remainder = digits.get(i) / 10;
            if (remainder == 0)
                continue;

            digits.set(i, digits.get(i) % 10);
            if (i != 0) {
                digits.set(i - 1, digits.get(i - 1) + remainder);
            } else {
                digits.add(0, remainder);
                i++; // correct for insertion
            }
        }

        while (digits.size() != 1 && digits.get(0) == 0) {
            digits.remove(0);
        }
    }

/**
 * Checks to see if an input LargeInteger is smaller than the current LargeInteger
 * 
 * @param num LargeInteger to check against this
 * @return true if it is, false otherwise
 */
	public boolean isSmallerThan(LargeInteger num) { //kind of a ridiculous method but I wrote it early on and don't want to abandon it.
		ArrayLargeInteger numIn = (ArrayLargeInteger)num;
		
		if((this.equals(ZERO) && numIn.isNegative) || (this.isNegative && numIn.equals(ZERO))) {
			return false;
		}else if((this.equals(ZERO) && !numIn.isNegative) || (!this.isNegative && numIn.equals(ZERO))){
			return true;
		}
			
		//case where one is negative
		if(this.isNegative && !numIn.isNegative)
			return true;
		if(!this.isNegative && numIn.isNegative)//unneeded?
			return false;
		
		//cases where both are negative
		if(this.isNegative && numIn.isNegative) {
			
			if(this.digits.size() > numIn.digits.size()) //it would be farther from 0 and therefore smaller
				return true;
			
			else if(this.digits.size() < numIn.digits.size()) //unneeded?
				return false;
		
			else if(this.digits.size() == numIn.digits.size()) {
				for(int i = 0; i < this.digits.size(); i++) { //iterate through the number
					
					//keeps looping while digits are ==
					if(this.digits.get(i) > numIn.digits.get(i)) //farther from 0
						return true;
					if(this.digits.get(i) < numIn.digits.get(i)) //the other is farther, prob not necessary
						return false;
				}
			}
		}
		
		//cases where both are positive
		if(this.digits.size() < numIn.digits.size())
			return true;
		
		else if(this.digits.size() > numIn.digits.size())
			return false;
		
		else if(numIn.digits.size() == this.digits.size()) {
			for(int i = 0; i < this.digits.size(); i++) { //iterate through the number
				
				//keeps looping while digits are ==
				if(this.digits.get(i) < numIn.digits.get(i)) //closer to 0
					return true;
				if(this.digits.get(i) > numIn.digits.get(i)) //the other is closer, prob not necessary
					return false;
			}
		}
		return false; //somehow, if you got past all that
	}
	
    @Override
    public boolean equals(Object other) {
        ArrayLargeInteger otherALI = (ArrayLargeInteger) other;
        if (this.signum() != otherALI.signum()) {
            return false;
        }
        if (this.digits.size() != otherALI.digits.size()) {
            return false;
        }
        for (int i = 0; i < this.digits.size(); i++) {
            if (this.digits.get(i) != otherALI.digits.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (digits.size() == 0 || (digits.size() == 1 && digits.get(0) == 0)) {
            return "0";
        }

        String result = isNegative ? "-" : "";
        for (Integer digit : digits) {
            result += digit;
        }

        return result;
    }

    @Override
	public int compareTo(LargeInteger num) {
		
		if(this.equals(num))
			return 0;
		
		if(this.isSmallerThan(num)) {
			return -1;
		}else { 
			return 1;	
		}
	}
     	
    @Override
    public LargeInteger add(LargeInteger other) {
        ArrayLargeInteger otherALI = (ArrayLargeInteger) other;

        if(this.equals(ZERO))
        	return otherALI;
        if(otherALI.equals(ZERO))
        	return this;
        
        //if needed, turn to subtraction
        if (!this.isNegative && otherALI.isNegative) {
            return this.subtract(otherALI.negate());
        }
        if (this.isNegative && !otherALI.isNegative) {
            return otherALI.subtract(this.negate());
        }

        
        boolean outIsNegative = this.isNegative && otherALI.isNegative;
        ArrayList<Integer> outDigits = new ArrayList<Integer>();

        int thisID = this.digits.size();
        int otherID = otherALI.digits.size();
        int greaterID = Math.max(thisID, otherID);

        while (greaterID >= 0) {
            thisID--;
            otherID--;
            greaterID--;
            final int a = (thisID < 0) ? 0 : this.digits.get(thisID);
            final int b = (otherID < 0) ? 0 : otherALI.digits.get(otherID);
            outDigits.add(a + b);
        }

        Collections.reverse(outDigits);
        ArrayLargeInteger output = new ArrayLargeInteger(outIsNegative, outDigits);
        output.carryDigits();
        return output;
    }

    @Override
    public LargeInteger subtract(LargeInteger other) {
        ArrayLargeInteger otherALI = (ArrayLargeInteger) other;

        if(this.equals(ZERO))
        	return otherALI;
        if(otherALI.equals(ZERO))
        	return this;
        
        // turn pos-neg to pos+pos
        if (this.isNegative == false && otherALI.isNegative) {
            return this.add(otherALI.negate());
        }

        // turn neg-neg to neg(neg) - abs(neg)
        if (this.isNegative && otherALI.isNegative) {
            return otherALI.negate().subtract(this.abs());
        }

        // change so greater.subtract(lesser)
        int compareResult = this.compareTo(otherALI);
        if (compareResult == 0) {
            return new ArrayLargeInteger("0");
        }

        if (compareResult == -1) {
            return otherALI.subtract(this).negate();
        }

        boolean outIsNegative = this.isNegative || this.compareTo(otherALI) == 0;
        ArrayList<Integer> outDigits = new ArrayList<Integer>();

        List<Integer> thisCopy = new ArrayList<Integer>(this.digits);
        int thisIndex = thisCopy.size() - 1;
        int otherIndex = otherALI.digits.size() - 1;

        while (thisIndex >= 0) {
            int digit = thisCopy.get(thisIndex);
            if (otherIndex >= 0) {
                digit -= otherALI.digits.get(otherIndex);

                //carry
                if (digit < 0) {
                    for (int i = thisIndex - 1; i >= 0; i--) {
                        if (thisCopy.get(i) > 0) {
                            thisCopy.set(i, (thisCopy.get(i) - 1));
                            for (int j = i + 1; j < thisIndex; j++) {
                                thisCopy.set(j, (thisCopy.get(j) + 9));
                            }
                            digit += 10;
                            break;
                        }
                    }
                }
            }

            outDigits.add(0, digit);
            thisIndex--;
            otherIndex--;
        }

        if (outDigits.get(0) == 0) {
            outDigits.remove(0);
        }

        ArrayLargeInteger output = new ArrayLargeInteger(outIsNegative, outDigits);
        output.carryDigits();
        return output;
    }

    @Override
    public LargeInteger negate() {
        ArrayLargeInteger output = new ArrayLargeInteger(this);
        output.isNegative = !output.isNegative;
        return output;
    }

    @Override
    public LargeInteger abs() {
        ArrayLargeInteger output = new ArrayLargeInteger(this);
        output.isNegative = false;
        return output;
    }

    @Override
    public LargeInteger multiply(LargeInteger other) {
        ArrayLargeInteger otherALI = (ArrayLargeInteger) other;
        if (this.equals(ZERO) || otherALI.equals(ZERO)) {
            return new ArrayLargeInteger(ZERO);
        }
        
        if(this.equals(ONE))
        	return otherALI;
        if(otherALI.equals(ONE))
        	return this;
        

        boolean outIsNegative = false;
        if (this.isNegative ^ otherALI.isNegative) {
            outIsNegative = true;
        }

        ArrayList<ArrayList<Integer>> subProductsToSum = new ArrayList<>();
        for (int i = otherALI.digits.size() - 1; i >= 0; i--) {

            ArrayList<Integer> subProduct = new ArrayList<Integer>();
            for (int j = this.digits.size() - 1; j >= 0; j--) {
                subProduct.add(this.digits.get(j) * otherALI.digits.get(i));
            }

            Collections.reverse(subProduct);
            subProductsToSum.add(subProduct);
        }

        // backfill zeros
        int largestDigitCount = 0;
        for (int i = 0; i < subProductsToSum.size(); i++) {
            for (int j = 0; j < i; j++) {
                subProductsToSum.get(i).add(0);
            }
            largestDigitCount = Math.max(largestDigitCount, subProductsToSum.get(i).size());
        }

        // frontfill zeros
        for (ArrayList<Integer> subProduct : subProductsToSum) {
            while (subProduct.size() != largestDigitCount) {
                subProduct.add(0, 0);
            }
        }

        ArrayList<Integer> product = new ArrayList<Integer>();

        for (int i = 0; i < largestDigitCount; i++) {
            // for (int i = subProductsToSum.size() - 1; i >= 0 ; i--) {
            int val = 0;

            for(ArrayList<Integer> subProduct : subProductsToSum) {
                // System.out.println(subProduct);
                val += subProduct.get(i);
            }
            // System.out.println(i);
            product.add(val);
        }

        ArrayLargeInteger output = new ArrayLargeInteger(outIsNegative, product);

        output.carryDigits();
        return output;
    }

    @Override
    public LargeInteger max(LargeInteger other) {
        int compare = this.compareTo(other);
        return compare <= 0 ? other : this;
    }

    @Override
    public LargeInteger min(LargeInteger other) {
        int compare = this.compareTo(other);
        return compare >= 0 ? other : this;
    }

    @Override
    public int signum() {
        if (digits.size() == 1 && digits.get(0) == 0) {
            return 0;
        }
        return isNegative ? -1 : 1;
    }
}


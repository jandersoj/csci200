package edu.unca.csci202;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    	printTimingData(1, 300, 1);
    	
//    	String zero = "0";
//    	String one = "1";
//    	
//    	String str1 = getRandIntString(10, false);
//    	String str2 = getRandIntString(12, false);
//    	String negStr1 = getRandIntString(10, true);
//    	String negStr2 = getRandIntString(12, true);
//    	    
//    	BigInteger zeroB= new BigInteger(zero);
//    	BigInteger oneB= new BigInteger(one);
//    	BigInteger pos1B = new BigInteger(str1);
//    	BigInteger pos2B = new BigInteger(str2);
//    	BigInteger neg1B = new BigInteger(negStr1);
//    	BigInteger neg2B = new BigInteger(negStr2);
//    	
//    	ArrayLargeInteger zeroA = new ArrayLargeInteger(zero);
//    	ArrayLargeInteger oneA = new ArrayLargeInteger(one);
//    	ArrayLargeInteger pos1A = new ArrayLargeInteger(str1);
//    	ArrayLargeInteger pos2A = new ArrayLargeInteger(str2);
//    	ArrayLargeInteger neg1A = new ArrayLargeInteger(negStr1);
//    	ArrayLargeInteger neg2A = new ArrayLargeInteger(negStr2);
    	
    	//and I had sundry tests after this as well.
    }

    private static int getRandomIntInRange(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }
    
    private static String getRandIntString(int length, boolean neg) {
    	 final Random rand = new Random();
    	 String num = "";
    	 if(neg) {
    		 num += "-";
    	 }
    	 
    	 for(int i = 0; i < length; i++) {
    		 num += getRandomIntInRange(rand, 0, 9);
    	 }
    	 return num;
    }
    
    //I asked my friend for help with this, it originally had the other half of the methods 
    //and then I changed it to have this half so that I wasn't running it all in one go.  
    
    private static void printTimingData(int minDigit, int maxDigit, int samplePerDigit) {
        final String header = "digit-count,bigInt-make,arrLg-make,bigInt-neg,arrLg-neg,bigInt-abs,arrLg-ans,bigInt-max,arrLg-max,bigInt-min,arrLg-min\n";
        final String numbers = "0123456789";
        final Random random = new Random();

        System.out.println("testing...");
        
        ArrayList<String> output = new ArrayList<String>();
        output.add(header);

        long startTime;
        for (int i = minDigit; i < maxDigit; i++) {
            for (int j = 0; j < samplePerDigit; j++) {

                String[] operands = new String[2];
                for (int operID = 0; operID < operands.length; operID++) {
                    operands[operID] = "";
                    if (random.nextDouble() > 0.5) {
                        operands[operID] = "-";
                    }
                    for (int k = 0; k < i; k++) {
                        operands[operID] += numbers
                                .charAt(getRandomIntInRange(random, (k == 0) ? 1 : 0, numbers.length()));
                    }
                }

                // System.out.println("A:" + operands[0] + ", B: " + operands[1]);

                // BigInteger ----------------------
                // Instantiation
                startTime = System.nanoTime();
                BigInteger bigIntOperandA = new BigInteger(operands[0]);
                long bigIntTimeMake = System.nanoTime() - startTime;
                BigInteger bigIntOperandB = new BigInteger(operands[1]); // Only need time data for one

                // Negate
                startTime = System.nanoTime();
                BigInteger bigIntResultNeg = bigIntOperandA.negate();
                long bigIntTimeNeg = System.nanoTime() - startTime;

                // Abs
                startTime = System.nanoTime();
                BigInteger bigIntResultAbs = bigIntOperandA.abs();
                long bigIntTimeAbs = System.nanoTime() - startTime;

                // Max
                startTime = System.nanoTime();
                BigInteger bigIntResultMax = bigIntOperandA.max(bigIntOperandB);
                long bigIntTimeMax = System.nanoTime() - startTime;

                // Min
                startTime = System.nanoTime();
                BigInteger bigIntResultMin = bigIntOperandA.min(bigIntOperandB);
                long bigIntTimeMin = System.nanoTime() - startTime;

                
                // ArrayLargeInteger ---------------
                // Instantiation
                startTime = System.nanoTime();
                ArrayLargeInteger arrLgOperandA = new ArrayLargeInteger(operands[0]);
                long arrayLargeMake = System.nanoTime() - startTime;
                ArrayLargeInteger arrLgOperandB = new ArrayLargeInteger(operands[1]); // Only need time data for one

                // Negations
                long arrayLargeNeg = 0;
                try {
                    startTime = System.nanoTime();
                    LargeInteger arrLgResultNeg = arrLgOperandA.negate();
                    arrayLargeNeg = System.nanoTime() - startTime;

                    if (bigIntResultNeg.toString().equals(arrLgResultNeg.toString()) == false) {
                        System.out.println("Failed addition with A:" + operands[0] + ", B:" + operands[1]);
                        System.out.println("Should be: [" + bigIntResultNeg.toString() + "] but got ["
                                + arrLgResultNeg.toString() + "]");
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Failed addition with A:" + operands[0] + ", B:" + operands[1]);
                    return;
                }

                // Abs
                long arrayLargeAbs = 0;
                try {
                    startTime = System.nanoTime();
                    LargeInteger arrLgResultAbs = arrLgOperandA.abs();
                    arrayLargeAbs = System.nanoTime() - startTime;

                    if (bigIntResultAbs.toString().equals(arrLgResultAbs.toString()) == false) {
                        System.out.println("Failed subtraction with A:" + operands[0] + ", B: " + operands[1]);
                        System.out.println("Should be: [" + bigIntResultAbs.toString() + "] \nbut got ["
                                + arrLgResultAbs.toString() + "]");
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Failed subtraction with A:" + operands[0] + ", B: " + operands[1]);
                    return;
                }

                // Max
                long arrayLargeMax = 0;
                try {
                    startTime = System.nanoTime();
                    LargeInteger arrLgResultMax = arrLgOperandA.max(arrLgOperandB);
                    arrayLargeMax = System.nanoTime() - startTime;

                    if (bigIntResultMax.toString().equals(arrLgResultMax.toString()) == false) {
                        System.out.println("Failed multiplication with A:" + operands[0] + ", B: " + operands[1]);
                        System.out.println("Should be: [" + bigIntResultMax.toString() + "] \n but got ["
                                + arrLgResultMax.toString() + "]");
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Failed multiplication with A:" + operands[0] + ", B: " + operands[1]);
                    return;
                }

                //Min
                long arrayLargeMin = 0;
                try {
                    startTime = System.nanoTime();
                    LargeInteger arrLgResultMin = arrLgOperandA.min(arrLgOperandB);
                    arrayLargeMin = System.nanoTime() - startTime;

                    if (bigIntResultMin.toString().equals(arrLgResultMin.toString()) == false) {
                        System.out.println("Failed multiplication with A:" + operands[0] + ", B: " + operands[1]);
                        System.out.println("Should be: [" + bigIntResultMin.toString() + "] \n but got ["
                                + arrLgResultMin.toString() + "]");
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Failed multiplication with A:" + operands[0] + ", B: " + operands[1]);
                    return;
                }
                
                output.add(String.format(
                        "%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d\n",
                        i,
                        bigIntTimeMake,
                        arrayLargeMake,
                        bigIntTimeNeg,
                        arrayLargeNeg,
                        bigIntTimeAbs,
                        arrayLargeAbs,
                        bigIntTimeMax,
                        arrayLargeMax,
                        bigIntTimeMin,
                        arrayLargeMin));
            }
        }
        for (String line : output) {
            System.out.print(line);
        }
    }
}

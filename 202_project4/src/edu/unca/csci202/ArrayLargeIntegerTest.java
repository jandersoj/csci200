package edu.unca.csci202;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import edu.unca.csci202.ArrayLargeInteger;
//import edu.unca.csci202.LargeInteger;

public class ArrayLargeIntegerTest {

	private final ByteArrayOutputStream redirectedOutStream = new ByteArrayOutputStream();
	private final PrintStream originalOutStream = System.out;

	public void redirectSystemOut() {
		System.setOut(new PrintStream(redirectedOutStream));
	}

	public void restoreSystemOut() {
		System.setOut(originalOutStream);
	}

	public void constructorStringTest() {
		System.out.println();
		System.out.println("Testing str constructors");
		
		String largeString = "123434343456789600059000000000000";
		LargeInteger largeALI = new ArrayLargeInteger(largeString);
		if (largeString.equals(largeALI.toString()) == false)
			System.out.println("Incorrect constructor for positive number: " + largeALI.toString());

		String largeNegString = "-123434343456789600059000000000000";
		LargeInteger largeNegALI = new ArrayLargeInteger(largeNegString);
		if (largeNegString.equals(largeNegALI.toString()) == false)
			System.out.println("Incorrect constructor for negative number: " + largeNegALI.toString());
	}

	public void constructorComponentTest() {
		System.out.println();
		System.out.println("Testing components constructor");
		boolean compA_isNegative = false;
		ArrayList<Integer> compA_digits = (ArrayList<Integer>) Arrays.asList(1, 2, 3);
		LargeInteger compA_ALI = new ArrayLargeInteger(compA_isNegative, compA_digits);
		
		if (compA_ALI.toString().equals("123") == false)
			System.out.println("Incorrect component constructor for positive number: " + compA_ALI.toString());

		boolean compB_isNegative = true;
		ArrayList<Integer> compB_digits = (ArrayList<Integer>) Arrays.asList(1, 2, 3);
		LargeInteger compB_ALI = new ArrayLargeInteger(compB_isNegative, compB_digits);

		if (compB_ALI.toString().equals("-123") == false)
			System.out.println("Incorrect component constructor for positive number: " + compB_ALI.toString());
	}

	
	public void negateAndAbsTest() {
		System.out.println();
		System.out.println("Testing negate and abs");
		LargeInteger orig_positive = new ArrayLargeInteger("123");
		orig_positive = orig_positive.negate();
		if (orig_positive.toString().contains("-") == false)
			System.out.println("originally_positive should be negative but is:" + orig_positive);

		LargeInteger orig_negative = new ArrayLargeInteger("-123");
		orig_negative = orig_negative.negate();
		if (orig_negative.toString().contains("-"))
			System.out.println("originally_positive should be negative but is: " + orig_negative.toString());
	}

	public void ZeroToStringTest() {
		System.out.println();
		System.out.println("Testing zero tostring");
		LargeInteger zero = new ArrayLargeInteger("0");
		zero = zero.negate();
		if (zero.toString().contains("-"))
			System.out.println("0 should not include - in toString");

	}

	public void additionTest() {
		System.out.println();
		System.out.println("Testing addition");
		
		// Simple
		ArrayLargeInteger valA = new ArrayLargeInteger("5");
		ArrayLargeInteger valB = new ArrayLargeInteger("8");
		System.out.println(new ArrayLargeInteger("13").toString() + "=" + valA.add(valB));

		ArrayLargeInteger valG = new ArrayLargeInteger("10");
		ArrayLargeInteger valH = new ArrayLargeInteger("250");
		System.out.println(new ArrayLargeInteger("260").toString() + "=" + valG.add(valH));

		// Carryover and insertion
		System.out.println();
		System.out.println("Testing carryover and insertion");		
		ArrayLargeInteger valC = new ArrayLargeInteger("6092");
		ArrayLargeInteger valD = new ArrayLargeInteger("4308");
		System.out.println(new ArrayLargeInteger("10400").toString() + "=" + valC.add(valD));

		// Double Negatives
		System.out.println();
		System.out.println("Testing adding negatives to positives");
		ArrayLargeInteger valE = new ArrayLargeInteger("-6092");
		ArrayLargeInteger valF = new ArrayLargeInteger("-4308");
		System.out.println(new ArrayLargeInteger("-10400").toString() + "=" + valE.add(valF));

		System.out.println(new BigInteger("0").add(new BigInteger("-5")).toString());
		System.out.println(new ArrayLargeInteger("0").add(new ArrayLargeInteger("-5")).toString());
		
		System.out.println(new BigInteger("1").add(new BigInteger("-5")).toString());
		System.out.println(new ArrayLargeInteger("1").add(new ArrayLargeInteger("-5")).toString());

		System.out.println(new BigInteger("15").add(new BigInteger("-10")).toString());
		System.out.println(new ArrayLargeInteger("15").add(new ArrayLargeInteger("-10")).toString());
	}

	public void subtractionTest() {
		System.out.println();
		System.out.println("Testing subtraction");
		
		ArrayLargeInteger valA = new ArrayLargeInteger("5");
		ArrayLargeInteger valB = new ArrayLargeInteger("8");
		System.out.println(new ArrayLargeInteger("-3").toString() + "=" + valA.subtract(valB));
		System.out.println(new ArrayLargeInteger("3").toString() + "=" + valB.subtract(valA));

		ArrayLargeInteger valC = new ArrayLargeInteger("18");
		ArrayLargeInteger valD = new ArrayLargeInteger("-8");
		System.out.println(new ArrayLargeInteger("26").toString() + "=" + valC.subtract(valD));
		System.out.println(new ArrayLargeInteger("-26").toString() + "=" + valD.subtract(valC));

		ArrayLargeInteger valE = new ArrayLargeInteger("512");
		ArrayLargeInteger valF = new ArrayLargeInteger("512");
		System.out.println(new ArrayLargeInteger("0").toString() + "=" + valE.subtract(valF));

		ArrayLargeInteger valG = new ArrayLargeInteger("0");
		ArrayLargeInteger valH = new ArrayLargeInteger("95");
		System.out.println(new ArrayLargeInteger("-95").toString() + "=" + valG.subtract(valH));
		System.out.println(new ArrayLargeInteger("95").toString() + "=" + valH.subtract(valG));

		// Negative - Negative
		ArrayLargeInteger valI = new ArrayLargeInteger("-123");
		ArrayLargeInteger valJ = new ArrayLargeInteger("-250");
		System.out.println(new ArrayLargeInteger("127").toString() + "=" + valI.subtract(valJ));
		System.out.println(new ArrayLargeInteger("-127").toString() + "=" + valJ.subtract(valI));

		// Same digit counts
		ArrayLargeInteger valK = new ArrayLargeInteger("1699");
		ArrayLargeInteger valL = new ArrayLargeInteger("9200");
		System.out.println(new ArrayLargeInteger("-7501").toString() + "=" + valK.subtract(valL));
		System.out.println(new ArrayLargeInteger("7501").toString() + "=" + valL.subtract(valK));
	}

	public void multiplicationTest() {
		System.out.println();
		System.out.println("Testing multiplication");
		ArrayLargeInteger valA = new ArrayLargeInteger("5");
		ArrayLargeInteger valB = new ArrayLargeInteger("8");
		System.out.println(new ArrayLargeInteger("40").toString() + "=" + valA.multiply(valB));

		ArrayLargeInteger valC = new ArrayLargeInteger("95");
		ArrayLargeInteger valD = new ArrayLargeInteger("48");
		System.out.println(new ArrayLargeInteger("4560").toString() + "=" + valC.multiply(valD));

		ArrayLargeInteger valE = new ArrayLargeInteger("10");
		ArrayLargeInteger valF = new ArrayLargeInteger("2005");
		System.out.println(new ArrayLargeInteger("20050").toString() + "=" + valE.multiply(valF));

		ArrayLargeInteger valG = new ArrayLargeInteger("123456789");
		ArrayLargeInteger valH = new ArrayLargeInteger("100000000000000");
		System.out.println(new ArrayLargeInteger("12345678900000000000000").toString() + "=" + valG.multiply(valH));

		ArrayLargeInteger valI = new ArrayLargeInteger("1231231782311231235342");
		ArrayLargeInteger valJ = new ArrayLargeInteger("16734987341891748134971892740871");
		System.out.println(
				new BigInteger("1231231782311231235342")
						.multiply(new BigInteger("16734987341891748134971892740871"))
						.toString() .toString() + "=" + valI.multiply(valJ).toString());

		ArrayLargeInteger valK = new ArrayLargeInteger("2356437546576879134617341276462138947013724821704612347");
		System.out.println(ArrayLargeInteger.ZERO.toString() + "=" + valK.multiply(ArrayLargeInteger.ZERO));
		System.out.println(valK.toString() + "=" + valK.multiply(ArrayLargeInteger.ONE));
	}

	public void compareTest() {
		System.out.println();
		System.out.println("Testing compare");
		ArrayLargeInteger simple_lower = new ArrayLargeInteger("5");
		ArrayLargeInteger simple_higher = new ArrayLargeInteger("8");
		if (simple_lower.compareTo(simple_higher) != -1)
			System.out.println("5.compare(8) should be -1 but is: " + simple_lower.compareTo(simple_higher));

		if (simple_higher.compareTo(simple_lower) != 1)
			System.out.println("5.compare(8) should be -1 but is: " + simple_lower.compareTo(simple_higher));

		ArrayLargeInteger sign_lower = new ArrayLargeInteger("-1072");
		ArrayLargeInteger sign_higher = new ArrayLargeInteger("1237");
		if (sign_lower.compareTo(sign_higher) != -1)
			System.out.println("-1072.compare(1237) should be -1 but is: " + sign_lower.compareTo(sign_higher));

		if (sign_higher.compareTo(sign_lower) != 1)
			System.out.println("-1072.compare(1237) should be -1 but is: " + sign_lower.compareTo(simple_higher));

		ArrayLargeInteger equal_valueA = new ArrayLargeInteger("1782390");
		ArrayLargeInteger equal_valueB = new ArrayLargeInteger("1782390");
		if (equal_valueA.compareTo(equal_valueB) != 0)
			System.out.println("1782390.compare(1782390) should be 0 but is: " + equal_valueA.compareTo(equal_valueB));

	}

	
	public void equalsObjectTest() {
		System.out.println();
		System.out.println("Testing equals");
		LargeInteger example = new ArrayLargeInteger("-123");
		LargeInteger otherExample = new ArrayLargeInteger("-123");

		if (example == otherExample) {
			System.out.println("example should not == exampleCopy");
		}
	}

	
	public void maxTest() {
		System.out.println();
		System.out.println("Testing max");
		LargeInteger one = ArrayLargeInteger.ONE;
		LargeInteger ten = ArrayLargeInteger.TEN;

		String oneMaxTenString = one.max(ten).toString();
		if (oneMaxTenString.equals("1"))
			System.out.println("Incorrect max(): " + oneMaxTenString);

		String tenMaxOneString = ten.max(one).toString();
		if (tenMaxOneString.equals("1"))
			System.out.println("Incorrect max(): " + tenMaxOneString);
	}

	
	public void minTest() {
		System.out.println();
		System.out.println("Testing min");
		LargeInteger one = ArrayLargeInteger.ONE;
		LargeInteger ten = ArrayLargeInteger.TEN;

		String oneMinTenString = one.min(ten).toString();
		if (oneMinTenString.equals("10"))
			System.out.println("Incorrect min(): " + oneMinTenString);

		String tenMinOneString = ten.min(one).toString();
		if (tenMinOneString.equals("10"))
			System.out.println("Incorrect min(): " + tenMinOneString);
	}

	
	public void signumTest() {
		System.out.println();
		System.out.println("Testing signum");
	
		LargeInteger zero = new ArrayLargeInteger("0");
		if (zero.signum() != 0)
			System.out.println("Incorrect signum() for 0: " + zero.signum());

		LargeInteger positive = new ArrayLargeInteger("12317");
		if (positive.signum() != 1)
			System.out.println("Incorrect signum() for 12317: " + positive.signum());

		LargeInteger negative = new ArrayLargeInteger("-81023");
		if (negative.signum() != -1)
			System.out.println("Incorrect signum() for -81023: " + negative.signum());
	}

}


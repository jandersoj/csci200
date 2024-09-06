package edu.unca.csci201;

/**
 * Text setBold, setItalics not quite right (-3). 
 * right idea for concat (in setBold, setItalics, and concat, 
 * your for-loops are incorrect) (-2). 
 * printHTML not correct (-1). [Written: 22/25]
 */

public class Main {

	public static void main(String[] args) {
		// you can include your own test code here
		
//		Letter l1 = new Letter("h");
//		Letter l2 = new Letter("i");
//		System.out.println(l1.character);
//		System.out.println(l2.character);
//		testLetter();
		testText();
	}
	
	public static void testLetter() {
		System.out.println("RUNNING TESTLETTER...");
		Letter l1 = new Letter('a');
		System.out.println(l1);
		Letter l2 = new Letter('B');
		System.out.println(l2);
		
		l1.setBold();
		System.out.println(l1);
		if (l1.isBold()) {
			System.out.println("l1 is bold"); // this should print
		}
		l1.unsetBold();
		if (!l1.isBold()) {
			System.out.println("l1 is NOT bold"); // this should print
		}
		l2.setBold();
		l2.setItalics();
		l2.printHTML(); //should have open b and i tags before, close tags after "B"
	}

	public static void testText() {
		System.out.println("RUNNING TESTTEXT...");

		Text t1 = new Text("word");
		t1.setBold(2, 3);
		t1.setItalics(1, 2);
		t1.printHTML(); //w<i>o<b>r</i>d</b>
		
		Text t2 = new Text("text");
		t2.setBold(0,1);
		t1.concat(t2);
//
		t1.printHTML(); //w<i>o<b>r</i>dte</b>xt
	}
}

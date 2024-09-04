package monday_demo;

/*
 * in class demo to show different ways of solving same codingbat problem
 * using static method, instance method, instance method with instance data,
 * and instance method with static data
 */

public class Main {
	// instance variable
	//private int[] data;
	// static variable (one copy shared by all objects)
	private static int[] data = {5, 6, 45, 99, 13, 5, 6};
	
	public Main() {
		// will access instance variable or static variable, depending
		// on which we've declared
		data = new int[7];
		data[0]=5;
		data[1]=6;
		data[2]=45;
		data[3]=99;
		data[4]=13;
		data[5]=5;
		data[6]=6;
	}
	
	// static codingbat version
//	public static boolean sameEnds(int[] nums, int len) {
//		int backIndex=nums.length-len;
//		for (int i=0; i<len; i++) {
//			// if different, return false
//			if (nums[i]!=nums[backIndex+i]) {
//				return false;
//			}
//		}
//		return true;
//	}

	// instance variable version but data passed as parameters
//	public boolean sameEnds(int[] nums, int len) {
//		int backIndex=nums.length-len;
//		for (int i=0; i<len; i++) {
//			// if different, return false
//			if (nums[i]!=nums[backIndex+i]) {
//				return false;
//			}
//		}
//		return true;
//	}

	// instance variable version but data is either an
	// instance or static variable
	public boolean sameEnds(int len) {
		int backIndex=data.length-len;
		for (int i=0; i<len; i++) {
			// if different, return false
			if (data[i]!=data[backIndex+i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		//int[] test = {5, 6, 45, 99, 13, 5, 6};
		boolean result=false;
		Main myObj = new Main();
		result = myObj.sameEnds(3);
		// when no instance variables, have to pass all data to method
		// when instance method, call with myObj.sameEnds
		//result = myObj.sameEnds(test, 3);
		// when sameEnds is static, can call Main.sameEnds
		// (or just sameEnds if we're in the Main class)
		//result = Main.sameEnds(test,3);
		System.out.println("result is "+result);
	}

}

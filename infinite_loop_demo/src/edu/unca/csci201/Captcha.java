package edu.unca.csci201;

import java.util.Random;

public class Captcha {
	int x;
	int y;
	int sum;
	
	public Captcha() {
		Random rand = new Random();
		x = rand.nextInt(20) + 1;
		y = rand.nextInt(20) + 1;
		sum = x + y;
	}
	
	public String getQuestion() {
				
		String question = "What is " + x + " + " + y +"?";
		System.out.println(question);
		return question;
	}
	
	public void runCheck(int givenSum) throws CaptchaCorrectException {
		CaptchaCorrectException correct = new CaptchaCorrectException("Correct!");
		if(givenSum == sum) {
			throw correct;
		} else return;
	}
}

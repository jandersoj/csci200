package edu.unca.csci201;

import java.util.Scanner;

public class CaptchaCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int z = 1;
		while (z < 5) {
			Captcha captcha = new Captcha();
			captcha.getQuestion();
			int answer = sc.nextInt();
			try {
				captcha.runCheck(answer);
			} catch (CaptchaCorrectException e) {
				z = 10;
				}
			}
		if(z==10) {
			System.out.println();
			System.out.println( "correct!!! you're human!");
			System.out.println("welcome to the secret human-only zone");
		}
	}

}

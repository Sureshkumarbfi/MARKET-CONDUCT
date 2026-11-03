package com.bornfire.xbrl.config;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class SequenceGenerator {
	private static final String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final int DOC_SEQ_ID = 9;
	private static final String NUM_LIST= "0123456789";


	public int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(NUM_LIST.length());

		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
	

	
	public String generateSeq() {

		StringBuffer randStr = new StringBuffer();
		
		
		for (int i = 0; i < DOC_SEQ_ID; i++) {
			int number = getRandomNumber();
			char ch = NUM_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
}
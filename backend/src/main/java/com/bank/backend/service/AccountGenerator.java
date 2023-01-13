package com.bank.backend.service;

import java.util.Random;

public class AccountGenerator {
	
	public String accountGenerator (String accountType) {
		
		
		
		String num = "0123456789";
		Random mRandom = new Random();
		String Result = "";		
		String Result1 = "";	
		
		
		for (int i = 0; i < 10; i++) {
			
			int position = mRandom.nextInt(num.length());
			char caracter = num.charAt(position);
			Result += caracter;
		}
			
			if (accountType.equalsIgnoreCase("checking")) {
				
				Result1="23"+Result.substring(2);
				
				
			}
			else if (accountType.equalsIgnoreCase("saving")) {
				
				Result1 = "46" + Result.substring(2);
				
			}

		
		
		return Result1;
		
		
	}

}

package com.jsp.bank.util;

import java.util.Random;

public class AccountUtil {
	
	public static long generateAccountNumber()
	{
		Random random = new Random();
		return 1000000000L + (long) (random.nextDouble() * 9000000000L);
	}

}

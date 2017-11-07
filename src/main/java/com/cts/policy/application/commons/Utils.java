package com.cts.policy.application.commons;

public class Utils {
	
	/**
	 * This method generates unique policy number
	 * @return
	 */
	public static long generatePolicyNumber() {
		long policyNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return policyNumber;
	}
}

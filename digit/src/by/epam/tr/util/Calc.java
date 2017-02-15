package by.epam.tr.util;

import java.util.ArrayList;

public final class Calc {

	private Calc() {}

	public static long multiplyDigit  (long value) {
		
		long result = (long) Math.signum(value);
		String str = Long.toString(Math.abs(value));

		for (int i = 0; i < str.length(); i++) {
			
			result = result * Character.getNumericValue(str.charAt(i));

		}
		return result;
	}
	

	public static void multiplyDigits  (ArrayList<Long> values) {
		
		for (int i = 0; i < values.size(); i++) {
			values.set(i, multiplyDigit(values.get(i)));
		}
	}
	
}

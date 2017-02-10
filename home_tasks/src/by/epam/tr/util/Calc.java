package by.epam.tr.util;

public class Calc {

	public static int multiplyDigits  (int value) {
		
		int result = 1;
		String str = Integer.toString(value);

		for (int i = 0; i < str.length(); i++) {
			
			result = result * Character.getNumericValue(str.charAt(i));

		}
		
		return result;
		
     
    
	}

}

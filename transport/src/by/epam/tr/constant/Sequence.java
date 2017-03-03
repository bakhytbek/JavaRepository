package by.epam.tr.constant;

public class Sequence {
	private static int starWith = 1;
	
	public static int nextVal() {
		return starWith++;
	}
	
}

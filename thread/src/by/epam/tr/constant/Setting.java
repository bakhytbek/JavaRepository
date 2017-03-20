package by.epam.tr.constant;

public class Setting {
	
	public static final int SHARES_COUNT = 10;
	public static final int SHARE_INIT_MIN_COST = 200;
	public static final int SHARE_INIT_MAX_COST = 500;

	public static final double SHARE_MIN_DISCOUNT = 0.5;
	public static final double SHARE_MAX_DISCOUNT = 5.0;
	
	
	
	public static final int BROKERS_COUNT = 20;
	
	public static final double BROKER_INIT_BALANS = 10_000;
	public static final double BROKER_MAX_SHARE_COUNT_PER_TRADE = 10;
	
	public static final int SLEEP_TIME_SECONDS = 2;
	

	private static int uniqueId;
	public static int getUniqueId () {
		return ++uniqueId;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}	
}

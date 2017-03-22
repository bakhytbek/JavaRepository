package by.epam.tr.stock;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import by.epam.tr.constant.Setting;


public class Stock {
	
	private class SharePrice {
		double cost;
		double discount;
	}
	
	private HashMap<String, SharePrice> shares;
	
	private Lock lock = new ReentrantLock();
	
	public Stock(int shareCont) {
		
		shares = new HashMap<>();
				
		for (int i=1; i <= shareCont; i++) {

			SharePrice p = new SharePrice();
			p.cost = ThreadLocalRandom.current().nextInt(Setting.SHARE_INIT_MIN_COST, Setting.SHARE_INIT_MAX_COST + 1);
			p.discount = ThreadLocalRandom.current().nextDouble(Setting.SHARE_MIN_DISCOUNT, Setting.SHARE_MAX_DISCOUNT);
			shares.put("Share" + i, p);
		}
	}
	

	public double getPrice(String shareName) {
		return shares.get(shareName).cost;
	}
	

	public double getDiscount(String shareName) {
		return shares.get(shareName).discount;
	}
	

	//return share count (increase price)
	public double buyShare(String shareName, Double amount) {
		
		lock.lock();
		try {
			double result = amount / shares.get(shareName).cost;
			shares.get(shareName).cost = shares.get(shareName).cost + shares.get(shareName).cost * shares.get(shareName).discount / 100;
			return result;
		}
		finally {
			lock.unlock();
		}
	}
	

	//return amount (decrease price)
	public double sellShare(String shareName, Double shareCount) {
		
		lock.lock();
		try {
			double result = shares.get(shareName).cost * shareCount;

			shares.get(shareName).cost = shares.get(shareName).cost - shares.get(shareName).cost * shares.get(shareName).discount / 100;

			return result;

		} finally {
			lock.unlock();
		}

	}


	
	public  Map<String, Double> getShares() {

		Comparator<String> byLength = Comparator.comparing(String::length);
		Comparator<String> byName = Comparator.comparing(String::toLowerCase);
		Comparator<String> orderBy = byLength.thenComparing(byName);

		return Collections.unmodifiableMap(shares.keySet()
												 .stream()
												 .sorted(orderBy)
												 .collect(Collectors.toMap(v -> v.toString(),
														 				   v -> Setting.round(getPrice(v.toString()), 2),
														 				   (v1,v2) ->{ throw new RuntimeException(String.format("Duplicate key for values %s and %s", v1, v2));},
														 				   LinkedHashMap::new)));
	}
	

	public  Map<String, Double> getSharesDiscount() {
		Comparator<String> byLength = Comparator.comparing(String::length);
		Comparator<String> byName = Comparator.comparing(String::toLowerCase);
		Comparator<String> orderBy = byLength.thenComparing(byName);

		return Collections.unmodifiableMap(shares.keySet()
												 .stream()
												 .sorted(orderBy)
												 .collect(Collectors.toMap(v -> v.toString(),
														 				   v -> Setting.round(getDiscount(v.toString()), 4),
														 				   (v1,v2) ->{ throw new RuntimeException(String.format("Duplicate key for values %s and %s", v1, v2));},
														 				   LinkedHashMap::new)));

	}
	
}

package by.epam.tr.broker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import by.epam.tr.constant.Setting;
import by.epam.tr.stock.Stock;

public class Broker implements Runnable, Comparable<Broker> {
	
	private String name;
	private double balans;
	
	private HashMap<String, Double> shares;
	private Stock stock;
	private CyclicBarrier barrier;
	
	private BrokerStatus status;
	

	public Broker(Stock stock, CyclicBarrier barrier, double balans) {
		
		this.name = "Broker" + Setting.getUniqueId();
		this.balans = balans;
		this.stock = stock;
		this.barrier = barrier;
		this.shares = new HashMap<>();
		this.status = BrokerStatus.BUYING;
	}
	
	@Override
	public void run() {
		
		if (status == BrokerStatus.BUYING) {
			buy();
			System.out.println("Stop buying " + this.name);
		} else {
			sell();
			System.out.println("Stop selling " + this.name);
		}		
		
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int compareTo(Broker broker) {
		return -1 * ((Double) this.balans).compareTo(broker.getBalans());
	}


	private void buy() {
		
		while (balans > 0.01) {
			
			//generate what share to buy
			String shareName = "Share" + ThreadLocalRandom.current().nextInt(1, Setting.SHARES_COUNT + 1);
			//generate how much to buy
			double shareAmount = ThreadLocalRandom.current().nextDouble(1, Setting.BROKER_MAX_SHARE_COUNT_PER_TRADE);
			//amount to buy
			double amount = shareAmount * stock.getPrice(shareName);


			if (amount < balans) {
				balans = balans - amount;
			} else {
				amount = balans;
				balans = 0;
			}


			//buying...			
			double shareCount = stock.buyShare(shareName, amount);

			shares.put(shareName, shareCount);


			try {
				TimeUnit.SECONDS.sleep(Setting.SLEEP_TIME_SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void sell() {
	 
		for(Map.Entry<String, Double> share : shares.entrySet()) {
		
		    String shareName = share.getKey();
    		Double shareCount = share.getValue();
    		
    		balans = balans + stock.sellShare(shareName, shareCount);

			try {
				TimeUnit.SECONDS.sleep(Setting.SLEEP_TIME_SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public BrokerStatus getStatus() {
		return status;
	}

	public void setStatus(BrokerStatus status) {
		this.status = status;
	}

	public double getBalans() {
		return balans;
	}
	
	public String getName() {
		return name;
	}
	
}

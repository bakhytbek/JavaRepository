package by.epam.tr.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import by.epam.tr.constant.Setting;
import by.epam.tr.stock.Stock;
import by.epam.tr.broker.Broker;
import by.epam.tr.broker.BrokerStatus;



public class Main {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		
		
		//INIT STOCK
		Stock stock = new Stock(Setting.SHARES_COUNT);
		ArrayList<Broker> brokers = new ArrayList<>();
		CyclicBarrier barrier = new CyclicBarrier(Setting.BROKERS_COUNT + 1); //+1 for main thread
		
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("--------------- Initial share price on stock --------------------");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(stock.getShares());
		//System.out.println(stock.getSharesDiscount());
		
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-------------------- Brokers balance ----------------------------");
		System.out.println("-----------------------------------------------------------------");
		for (int i = 1; i <= Setting.BROKERS_COUNT; i++) {
			Broker brocker = new Broker(stock, barrier, Setting.BROKER_INIT_BALANS);
			brokers.add(brocker);
			System.out.println((i+1) + "." + brocker.getName() + ", balance = " + brocker.getBalans());
		}
		
		
		//BROKERS RUN BUYING SHARES
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-------------------- Run buying shares --------------------------");
		System.out.println("-----------------------------------------------------------------");
		for (int i = 0; i <= Setting.BROKERS_COUNT-1; i++) {
			new Thread(brokers.get(i)).start();
		}
		barrier.await();


		//BROKERS STOP BUYING SHARES
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-------------------- Brokers balance ----------------------------");
		System.out.println("-----------------------------------------------------------------");
		Collections.sort(brokers);
		for (int i = 0; i < brokers.size(); i++) {
			System.out.println((i+1) + "." + brokers.get(i).getName() + ", balance = " + brokers.get(i).getBalans());
		}

		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("--------------- Current share price on stock --------------------");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(stock.getShares());
		//System.out.println(stock.getSharesDiscount());

		
		//BROKERS RUN SELLING SHARES
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-------------------- Run selling shares --------------------------");
		System.out.println("-----------------------------------------------------------------");

		barrier.reset();
		for (int i = 0; i < brokers.size(); i++) {
			brokers.get(i).setStatus(BrokerStatus.SELLING);
			new Thread(brokers.get(i)).start();
		}
		barrier.await();
		

		//BROKERS STOP SELLING SHARES
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-------------------- Brokers balance ----------------------------");
		System.out.println("-----------------------------------------------------------------");
		Collections.sort(brokers);
		for (int i = 0; i < brokers.size(); i++) {
			System.out.println((i+1) + "." + brokers.get(i).getName() + ", balance = " + brokers.get(i).getBalans());
		}
			
	}

}

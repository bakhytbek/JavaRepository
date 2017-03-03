package by.epam.tr.train;

import java.util.HashMap;

public class WagonPark {

	//Wagon list
	private HashMap<Integer, Wagon> wagons;
	
	public Wagon getWagon(int wagonId) {
		return wagons.get(wagonId);
	}

	public HashMap<Integer, Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(HashMap<Integer, Wagon> wagons) {
		this.wagons = wagons;
	}

}

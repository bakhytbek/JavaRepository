package by.epam.tr.train;

import java.util.HashMap;

import by.epam.tr.constant.Sequence;

public class Train {
	
	private int id;
	
	//Wagon list
	private HashMap<Integer, Wagon> wagons;
	
	
	public Train() {
		id = Sequence.nextVal();
	}

	
	public HashMap<Integer, Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(HashMap<Integer, Wagon> wagons) {
		this.wagons = wagons;
	}

	public int getId() {
		return id;
	}


	//Add wagon to Train
	public boolean addWagon(Wagon wagon, int boardedPassenger, int boardedLuggage) {

		if (!this.getWagons().containsKey(wagon.getId()) && !wagon.isInUse())  {
			
			this.getWagons().put(wagon.getId(), wagon);
			
			if (wagon instanceof PassengerWagon) {
				((PassengerWagon) wagon).setBoardedPassenger(boardedPassenger);
				((PassengerWagon) wagon).setBoardedLuggage(boardedLuggage);
			}
			wagon.setInUse(true);
			
			return true;
		} 
		
		return false;
	}
	
	//Remove wagon from Train
	public boolean removeWagon(Wagon wagon) {
		
		if (this.getWagons().containsKey((wagon.getId())))  {
			
			this.getWagons().remove(wagon.getId());
			
			if (wagon instanceof PassengerWagon) {
				((PassengerWagon) wagon).setBoardedPassenger(0);
				((PassengerWagon) wagon).setBoardedLuggage(0);
			}
			
			wagon.setInUse(false);
			return true;
		} 
		
		return false;
	}
	
}

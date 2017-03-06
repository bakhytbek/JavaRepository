package by.epam.tr.main;

import by.epam.tr.action.Action;
import by.epam.tr.io.DataInput;
import by.epam.tr.train.Train;
import by.epam.tr.train.WagonPark;


public class Main {

	public static void main(String[] args) {
		
		//wagons park
		WagonPark wagonPark = new WagonPark();
		wagonPark.setWagons(DataInput.readWagons("data\\wagons.txt"));

		//train
		Train train = new Train();
		train.setWagons(DataInput.readTrainWagons("data\\train1.txt", wagonPark.getWagons()));
		
		//train summaring
		System.out.println("===================================");
		System.out.println("======TOTAL BOARDED PASSENGERS=====");
		System.out.println("===================================");

		System.out.println(Action.sumBoardedPassenger(train.getWagons()));
		
		
		

		//train ordering
		System.out.println("===================================");
		System.out.println("====ORDER BY NAME ASC, ID DESC=====");
		System.out.println("===================================");
		
		Action.orderByNameId(train.getWagons()).forEach((wagonId, wagon)->{System.out.println(wagonId + " : " + wagon.getName());});
		
		
		

		//train filtering
		System.out.println("===================================");
		System.out.println("==FILTER: BOARDED_PASSENGERS > 10==");
		System.out.println("===================================");

		Action.filterBoardedPassenger(train.getWagons(), 10).forEach((wagonId, wagon)->{System.out.println(wagonId + " : " + wagon.getName() + " (" + wagon.getBoardedPassenger() + ")");});

		
		
		
		//train filtering
		System.out.println("===================================");
		System.out.println("=======FILTER: LOCOMOTIVE==========");
		System.out.println("===================================");
		
		Action.filterLocomotive(train.getWagons()).forEach((wagonId, wagon)->{System.out.println(wagonId + " : " + wagon.getName() + " (" + wagon.isLocomotive() + ")");});
		
	
	}
}

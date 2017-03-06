package by.epam.tr.action;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import by.epam.tr.train.PassengerWagon;
import by.epam.tr.train.Wagon;

public class Action {
	
	public static int sumBoardedPassenger(Map <Integer, Wagon> map) {
	
		int[] mutable = {0};
		map.entrySet().forEach((entry)->{mutable[0] = mutable[0] + entry.getValue().getBoardedPassenger();});
		return mutable[0];
	
	}
	
	public static Map<Integer, Wagon> orderByNameId (Map <Integer, Wagon> map) {

		Comparator<Entry<Integer, Wagon>> byName = (e1,e2)-> e1.getValue().getName().compareTo(e2.getValue().getName());
		Comparator<Entry<Integer, Wagon>> byId = (e1,e2)-> e1.getValue().getId().compareTo(e2.getValue().getId());
		
		Comparator<Entry<Integer, Wagon>> orderBy = byName.thenComparing(byId.reversed());
		
		
		return map.entrySet()
	              .stream()
	              .sorted(orderBy)
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue,
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}


	public static Map<Integer, Wagon> filterBoardedPassenger (Map <Integer, Wagon> map, int boardedPassenger) {

		return map.entrySet()
	              .stream()
	              .filter(entry -> entry.getValue() instanceof PassengerWagon)
	              .filter(entry -> ((PassengerWagon)entry.getValue()).getBoardedPassenger() > boardedPassenger)
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue,
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}


	public static Map<Integer, Wagon> filterLocomotive (Map <Integer, Wagon> map) {
		
		return map.entrySet()
	              .stream()
	              .filter(entry -> entry.getValue().isLocomotive())
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue,
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}

}

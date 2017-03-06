package by.epam.tr.io;

import by.epam.tr.constant.Setting;
import by.epam.tr.exception.WagonParseException;
import by.epam.tr.train.EngineType;
import by.epam.tr.train.Locomotive;
import by.epam.tr.train.PassengerWagon;
import by.epam.tr.train.ServiceType;
import by.epam.tr.train.Wagon;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//Input data from file
public class DataInput {
	
	private static Logger logger = LogManager.getLogger(DataInput.class.getName());
	
	

//to support WAGON file format (readWagons, addWagon, parseWagonFormat)
	
	public static HashMap<Integer, Wagon> readWagons(String fileName) {
		
		Path path = Paths.get(fileName);
		
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {

			HashMap<Integer, Wagon> wagons = new HashMap<>();			

			lines.filter(line -> !line.startsWith(Setting.PREFIX_COMMENT))
			     .forEach(line -> addWagon(line, wagons));
			     
			return wagons;
		}
		catch (IOException e) {
			//log4j
			logger.error(String.format(Setting.LOG_ERROR_FILE_READ, fileName));
			return null;		
		}
		 
	}
	
	private static void addWagon(String line, HashMap<Integer, Wagon> wagons) {
		
		try {
			if (!line.isEmpty()) {

				Wagon wagon = parseWagonFormat(line);

				if (wagon != null) {
					wagons.put(wagon.getId(), wagon);
					//log4j info
					logger.info("Wagon Park: " + wagon.getId() + " - " + wagon.getName());
				}
			}
		} 
		catch (WagonParseException e) {
			logger.error(e.getMessage());
		}
	}
	
	
	public static Wagon parseWagonFormat(String line) throws WagonParseException {

		Wagon wagon = null;
		String[] fields = line.split(Setting.DELIMITER_FIELD);

		try {

			if (fields[0].equals(Setting.PREFIX_LOCOMOTIVE)) {
				wagon = new Locomotive();
			} else if (fields[0].equals(Setting.PREFIX_PASSENGER_WAGON)) {
				wagon = new PassengerWagon();
			} else {
				throw new WagonParseException(String.format(Setting.LOG_ERROR_INVALID_WAGON_CODE, fields[0], line));
			}

			wagon.setId(Integer.parseInt(fields[1]));
			wagon.setName(fields[2]);
			wagon.setBuilder(fields[3]);

		    wagon.setBuildDate(LocalDate.parse(fields[4], DateTimeFormatter.ofPattern(Setting.FORMAT_DATE)));
		    
  
			wagon.setWheelsetWidth(Double.parseDouble(fields[5]));
			wagon.setWheelsetNumber(Integer.parseInt(fields[6]));
			wagon.setMaxSpeed(Integer.parseInt(fields[7]));

			if (wagon instanceof Locomotive) {
				// engine_type
				try {
					((Locomotive) wagon).setEngineType(EngineType.valueOf(fields[8].toUpperCase()));
				} catch (IllegalArgumentException e) {
					throw new WagonParseException(String.format(Setting.LOG_ERROR_INVALID_ENGINE_TYPE, fields[8], line), e);
				}

				((Locomotive) wagon).setEnginePower(Integer.parseInt(fields[9]));

			} else if (wagon instanceof PassengerWagon) {

				// service_type
				try {
					((PassengerWagon) wagon).setServiceType(ServiceType.valueOf(fields[8].toUpperCase()));
				} catch (IllegalArgumentException e) {
					throw new WagonParseException(String.format(Setting.LOG_ERROR_INVALID_SERVICE_TYPE, fields[8], line), e);
				}

				((PassengerWagon) wagon).setCapacityPassenger(Integer.parseInt(fields[9]));
				((PassengerWagon) wagon).setCapacityLuggage(Integer.parseInt(fields[10]));

			}

			return wagon;

		} 
		catch (NumberFormatException|ArrayIndexOutOfBoundsException|DateTimeParseException e) {
			throw new WagonParseException(String.format(Setting.LOG_ERROR_INVALID_WAGON_FORMAT, line), e);
		}
	}


	
//to support TRAIN file format (readTrainWagons, addTrainWagon, parseTrainFormat)

	static private class TrainFormat {
		private int wagonId;
		private int boardedPassenger;
		private int boardedLuggage;
	}	

	
	public static HashMap<Integer, Wagon> readTrainWagons(String fileName, HashMap<Integer, Wagon> wagons) {

		Path path = Paths.get(fileName);
		
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {

			HashMap<Integer, Wagon> trainWagons = new HashMap<>();			
			
			lines.filter(line -> !line.startsWith(Setting.PREFIX_COMMENT))
			     .forEach(line -> addTrainWagon(line, wagons, trainWagons));
			
			return trainWagons;
		}
		catch (IOException e) {
			//log4j
			logger.error(String.format(Setting.LOG_ERROR_FILE_READ, fileName));
			return null;
		}
		 
	}


	private static void addTrainWagon(String line, HashMap<Integer, Wagon> wagons, HashMap<Integer, Wagon> trainWagons) {

		try {
			if (!line.isEmpty()) {

				TrainFormat trainFormat = parseTrainFormat(line);
				
				Wagon wagon = wagons.get(trainFormat.wagonId);
				
				
				if (wagon == null) {
					//log4j warning
					logger.error(String.format(Setting.LOG_ERROR_INVALID_TRAIN_WAGON, line));
				} 
				else if (wagon.isInUse()) {
					//log4j warning
					logger.error(String.format(Setting.LOG_ERROR_INVALID_TRAIN_WAGON_ADD, line));
				} 
				else {
					
					trainWagons.put(wagon.getId(), wagon);
					wagon.setInUse(true);

					if (wagon instanceof PassengerWagon) {
						((PassengerWagon) wagon).setBoardedPassenger(trainFormat.boardedPassenger);
						((PassengerWagon) wagon).setBoardedLuggage(trainFormat.boardedLuggage);
					}
					//log4j info
					logger.info("Train: " + wagon.getId() + " - " + wagon.getName());
				}
			}
		}
		catch (WagonParseException e) {
			logger.error(e.getMessage());
		}
	}

	
	public static TrainFormat parseTrainFormat(String line) throws WagonParseException {
		
		TrainFormat trainFormat = new TrainFormat();

		try {
			String[] fields = line.split(Setting.DELIMITER_FIELD);

			trainFormat.wagonId = Integer.parseInt(fields[0]); 
			trainFormat.boardedPassenger = Integer.parseInt(fields[1]);
			trainFormat.boardedLuggage = Integer.parseInt(fields[2]);
			
			return trainFormat;

		} catch (NumberFormatException e) {
			throw new WagonParseException(String.format(Setting.LOG_ERROR_INVALID_TRAIN_FORMAT, line), e);
		}
	}

}


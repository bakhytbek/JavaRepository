package by.epam.tr.train;

import java.time.LocalDate;


public class Wagon {

	
	private WagonType type;	//{LOKOMOTIVE, PASSENGER_WAGON}

	private boolean inUse;
	
	private int id;			//unique wagon identifier

	private String name;
	private String builder;
	private LocalDate buildDate;
	private double wheelsetWidth;	// in milimeters 
	private int wheelsetNumber;
	private int maxSpeed;			// in km/h 
	

	public Wagon(int id) {

		this.id = id;
	}
	
	public Wagon() {
		super();
	}

	public boolean isInUse() {
		return inUse;
	}
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	
	public WagonType getType() {
		return type;
	}
	public void setType(WagonType type) {
		this.type = type;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public LocalDate getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(LocalDate buildDate) {
		this.buildDate = buildDate;
	}
	public double getWheelsetWidth() {
		return wheelsetWidth;
	}
	public void setWheelsetWidth(double wheelsetWidth) {
		this.wheelsetWidth = wheelsetWidth;
	}
	public int getWheelsetNumber() {
		return wheelsetNumber;
	}
	public void setWheelsetNumber(int wheelsetNumber) {
		this.wheelsetNumber = wheelsetNumber;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public Boolean isLocomotive() {
		return (this instanceof Locomotive);
	}
	
	public int getBoardedPassenger() {
		return 0;
	}
	
	public int getBoardedLuggage() {
		return 0;
	}

}

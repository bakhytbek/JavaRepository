package by.epam.tr.train;

public class PassengerWagon extends Wagon {
	
	private ServiceType serviceType;	//{TOURIST, BUSINESS, GRAND}
	
	private int capacityPassenger;  	//maximum passengers capacity
	private int capacityLuggage;		//maximum luggage capacity (kg)
	
	private int boardedPassenger;		//boarded passengers
	private int boardedLuggage;			//boarded luggage (kg)
	
	
	@Override
	public int getBoardedPassenger() {
		return boardedPassenger;
	}
	
	@Override
	public int getBoardedLuggage() {
		return boardedLuggage;
	}
	
	
	public int getCapacityPassenger() {
		return capacityPassenger;
	}
	public void setCapacityPassenger(int capacityPassenger) {
		this.capacityPassenger = capacityPassenger;
	}
	public int getCapacityLuggage() {
		return capacityLuggage;
	}
	public void setCapacityLuggage(int capacityLuggage) {
		this.capacityLuggage = capacityLuggage;
	}
	public void setBoardedPassenger(int boardedPassenger) {
		this.boardedPassenger = boardedPassenger;
	}
	public void setBoardedLuggage(int boardedLuggage) {
		this.boardedLuggage = boardedLuggage;
	}
	public ServiceType getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	
}

package by.epam.tr.train;

public class Locomotive extends Wagon {
	
	
	private EngineType engineType;	//{DIESEL, DIESEL_ELECTRIC, ELECTRIC}

	private int enginePower;		//in hp (horse power)
	
	
	public EngineType getEngineType() {
		return engineType;
	}
	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}
	
	public int getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}
	
				
	
	
}

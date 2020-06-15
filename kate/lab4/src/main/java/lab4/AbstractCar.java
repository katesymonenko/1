package lab4;

public class AbstractCar <T extends Human> extends AbstractVehicle<T> {
	
	public AbstractCar (int seatsAmount) {
		super(seatsAmount);
	}
	
}

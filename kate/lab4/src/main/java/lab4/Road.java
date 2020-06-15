package lab4;

import java.util.List;
import java.util.ArrayList;

public class Road {
	private List<AbstractVehicle> carsInRoad = new ArrayList<AbstractVehicle>();
	
	public int getCountOfHumans(){
		return this.carsInRoad
			.stream()
			.map((car) -> car.getPassengersAmount())
			.reduce(0, (acc, passengers) -> {
				return acc + passengers;
			});
	}
	
	public void addCarToRoad (List<? extends AbstractCar> carsList) {
		this.carsInRoad.addAll(carsList);
	}
}

package lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class RoadTest {
	private Road road;
	
	@BeforeEach
	public void init () {
		this.road = new Road();
	}
	
	private Taxi makeTaxiWithPassengers (int passengersAmount) {
		Taxi taxi = new Taxi();
		for (int i = 0; i < passengersAmount; i++) {
			taxi.addPassenger(new Human());
		}
		return taxi;
	}
	
	@Test
	public void shouldAddCarsAtRoad () {
		ArrayList<Taxi> cars = new ArrayList<Taxi>();
		cars.add(this.makeTaxiWithPassengers(3));
		cars.add(this.makeTaxiWithPassengers(2));

		Assertions.assertDoesNotThrow(() -> {
			this.road.addCarToRoad(cars);
		});
	}

	@Test
	public void shouldCorrectlyComputateTotalAmountOfPassengers () {
		ArrayList<Taxi> cars = new ArrayList<Taxi>();
		cars.add(this.makeTaxiWithPassengers(3));
		cars.add(this.makeTaxiWithPassengers(2));
		cars.add(this.makeTaxiWithPassengers(5));
		int expectedAmount = 10;
		this.road.addCarToRoad(cars);
		
		int actualAmount = this.road.getCountOfHumans();
		
		Assertions.assertEquals(expectedAmount, actualAmount);
	}
}

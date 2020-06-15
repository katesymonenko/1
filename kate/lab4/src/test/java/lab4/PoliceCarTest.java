package lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PoliceCarTest {

	private PoliceCar policeCar;
	
	@BeforeEach 
	public void init () {
		this.policeCar = new PoliceCar();
	}
	
	@Test
	public void shouldGetPredefinedSeatsAmount() {
		int expectedSeatsAmount = 5;
		
		int actualSeatsAmount = this.policeCar.getSeatsAmount();
		
		Assertions.assertEquals(expectedSeatsAmount, actualSeatsAmount);
	}
	
	@Test
	public void shouldGetPassengersAmount () {		
		int actualPassengersAmount = this.policeCar.getPassengersAmount();
		
		Assertions.assertEquals(0, actualPassengersAmount);
	}

	@Test
	public void shouldCorrectlyAddPassenger () {
		Policeman policeman = new Policeman();
		int passengersAmountBefore = this.policeCar.getPassengersAmount();
		
		this.policeCar.addPassenger(policeman);
		int passengersAmountAfter = this.policeCar.getPassengersAmount();
		
		Assertions.assertEquals(passengersAmountBefore, 0);
		Assertions.assertEquals(passengersAmountAfter, 1);
	}
	
	@Test
	public void shouldThrowOnAddSamePassengerTwice () {
		Policeman policeman = new Policeman();
		this.policeCar.addPassenger(policeman);
		
		Assertions.assertThrows(
			IllegalArgumentException.class,
			() -> {
				this.policeCar.addPassenger(policeman);
			}
		);
	}
	
	@Test
	public void shouldThrowOnAddPassengerOverSeatsAmount () {
		for (int i = 0; i < this.policeCar.getSeatsAmount(); i++) {
			this.policeCar.addPassenger(new Policeman());
		}
		Assertions.assertThrows(
			IllegalStateException.class,
			() -> {
				this.policeCar.addPassenger(new Policeman());
			}
		);
	}
	
	@Test
	public void shouldRemovePassenger () {
		Policeman policeman = new Policeman();
		this.policeCar.addPassenger(policeman);
		int passengersAmountBefore = this.policeCar.getPassengersAmount();
		
		this.policeCar.removePassenger(policeman);
		int passengersAmountAfter = this.policeCar.getPassengersAmount();
		
		Assertions.assertEquals(passengersAmountBefore, 1);
		Assertions.assertEquals(passengersAmountAfter, 0);
	}
	
	@Test
	public void shouldThrowOnRemovePassengerOutOfCar () {
		Policeman policeman = new Policeman();
		
		Assertions.assertThrows(
			IllegalArgumentException.class,
			() -> {
				this.policeCar.removePassenger(policeman);
			}
		);
	}

}

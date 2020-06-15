package lab4;

import java.util.UUID;
import java.util.HashMap;

abstract public class AbstractVehicle <T extends Human> {

	private UUID id;
	private int seatsAmount;
	private HashMap<UUID, T> passengers;
	
	public AbstractVehicle(int seatsAmount) {
		this.id = UUID.randomUUID();
		this.seatsAmount = seatsAmount;
		this.passengers = new HashMap<UUID, T>();
	}

	public UUID getId () {
		return this.id;
	}
	
	public int getSeatsAmount () {
		return this.seatsAmount;
	}
	
	public int getPassengersAmount () {
		return this.passengers.size();
	}
	
	public void addPassenger (T passenger) {
		if (this.passengers.size() == this.seatsAmount) {
			throw new IllegalStateException("Vehicle is full");
		}
		if (this.passengers.get(passenger.getId()) != null) {
			throw new IllegalArgumentException("Passenger is already in vehicle");
		}
		this.passengers.put(passenger.getId(), passenger);
	}
	
	public void removePassenger (T passenger) {
		if (this.passengers.get(passenger.getId()) == null) {
			throw new IllegalArgumentException("Passenger is not in vehicle. Can't be removed");
		}
		this.passengers.remove(passenger.getId());
	}
}

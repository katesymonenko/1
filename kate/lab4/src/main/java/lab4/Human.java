package lab4;

import java.util.UUID;

public class Human {

	private UUID id;
	
	public Human() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

}

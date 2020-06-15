package lab3;

import cardsMeta.CardsMeta;

public class CardByTrips extends AbstractCard {

	private int grantedTrips;
	
	public CardByTrips (int id, CardsMeta cardsMeta, int grantedTrips) {
		super(id, cardsMeta, CARD_TYPE.WITH_GRANTED_TRIPS);
		this.grantedTrips = grantedTrips;
	}
	
	public Boolean isValid () {
		return super.isValid() && this.grantedTrips != 0;
	}
	
	public void use () {
		this.grantedTrips -= 1;
	}

	public CardsMeta getCardsMeta(Card card) {
		return super.getCardsMeta();
	}

}

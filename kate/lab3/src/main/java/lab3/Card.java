package lab3;

import cardsMeta.CardsMeta;

public interface Card {
	public Boolean isValid ();
	
	public void use ();
	
	public int getId ();
	
	public CARD_TYPE getCardType ();
	
	public void setIsBlocked (Boolean isBlocked);
	
	public CardsMeta getCardsMeta (Card card);
}

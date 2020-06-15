package lab3;

import cardsMeta.CardsMeta;

public abstract class AbstractCard implements Card {
	private int id;
	private CardsMeta cardsMeta;
	private Boolean isBlocked;
	private CARD_TYPE cardType;
	
	public AbstractCard (int id, CardsMeta cardsMeta, CARD_TYPE cardType) {
		this.id = id;
		this.setCardsMeta(cardsMeta);
		this.setIsBlocked(false);
		this.setCardType(cardType);
	}

	public abstract void use ();
	
	public int getId () {
		return this.id;
	}

	public CardsMeta getCardsMeta() {
		return this.cardsMeta;
	}

	public void setCardsMeta(CardsMeta cardsMeta) {
		this.cardsMeta = cardsMeta;
	}
	
	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	public Boolean isValid () {
		return !this.getIsBlocked();
	}

	public CARD_TYPE getCardType() {
		return cardType;
	}

	private void setCardType(CARD_TYPE cardType) {
		this.cardType = cardType;
	}
}

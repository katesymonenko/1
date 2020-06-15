package lab3;

import cardsMeta.CardsMeta;

public class Gate {
	private Register register;
	private GateSygnals gateSygnals;
	
	public Gate (Register register, GateSygnals gateSygnals) {
		this.register = register;
		this.gateSygnals = gateSygnals;
	}
	
	public void onContact (Card card) {
		int id = card.getId();
		Card realCard = this.getCardFromRegister(id);
		if (realCard == null) {
			return;
		}
		this.handleCardsMeta(card);
		if(realCard.isValid()) {
			this.register.onCardPass(realCard);
			return;
		}
		this.register.onCardReject(realCard);
	}
	
	private void handleCardsMeta (Card card) {
		CardsMeta cardsMeta = card.getCardsMeta(card);
		if (cardsMeta.getIsVIP()) {
			// зажечь лампочку для диспетчера
			this.gateSygnals.emitMoveAheadOfTheLine();
		}
		if (cardsMeta.getIsDiscounted()) {
			// уведомление о необходимости пропустить владельца карты без очереди
			this.gateSygnals.emitWarn();
		}
	}
	
	private Card getCardFromRegister (int id) {
		return register.getCardById(id);
	}
	
}

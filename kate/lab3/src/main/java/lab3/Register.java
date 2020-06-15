package lab3;

import java.util.HashMap;
import java.util.ArrayList;

import cardsMeta.CardsMeta;
import historyEntry.HISTORY_ENTRY_TYPE;
import historyEntry.HistoryEntry;

// TODO: getCardHistoryBy
public class Register {
	private HashMap<Integer, Card> registeredCards;
	private int idForNextCard;
	private ArrayList<HistoryEntry> history;
	
	public Register () {
		this.registeredCards = new HashMap<Integer, Card>();
		// Поскольку в регистре будут храниться даже просроченные карты 
		// используем инкрементальный id, чтобы избежать возможного пересечения id
		this.idForNextCard = 1;
		this.history = new ArrayList<HistoryEntry>();
	}
	
	public Card makeCardWithGrantedTrips (int grantedTrips, CardsMeta cardsMeta) {
		Card card = new CardByTrips(this.idForNextCard, cardsMeta, grantedTrips);
		return this.registerCard(card);
	}
	
	public Card makePeriodicalCard (CARD_TYPE cardType, int grantedDays, CardsMeta cardsMeta) {
		int id = this.idForNextCard;
		Card card = new CardByPeriod(id, cardsMeta, cardType, grantedDays);
		return this.registerCard(card);
	}
	
	public Card getCardById (int id) {
		return this.registeredCards.get(id);
	}
	
	public void blockCardById (int id) {
		Card card = this.getCardById(id);
		card.setIsBlocked(true);
	}

	public void onCardPass (Card card) {
		card.use();
		this.pushHistoryEntry(HISTORY_ENTRY_TYPE.PASS, card);
	}
	
	public void onCardReject (Card card) {
		this.pushHistoryEntry(HISTORY_ENTRY_TYPE.REJECT, card);
	}

	private void pushHistoryEntry (HISTORY_ENTRY_TYPE entryType, Card card) {
		HistoryEntry historyEntry = new HistoryEntry(
			card.getId(),
			entryType,
			card.getCardType()
		);
		this.history.add(historyEntry);
	}
	
	public ArrayList<HistoryEntry> getHistory () {
		return this.history;
	}
	
	public ArrayList<HistoryEntry> getHistoryByCardId (int cardId) {
		ArrayList<HistoryEntry> historySlice = new ArrayList<HistoryEntry>();
		this.history.forEach((historyEntry) -> {
			if (historyEntry.getCardId() == cardId) {
				historySlice.add(historyEntry);
			}
		});
		return historySlice;
	}
	
	public ArrayList<HistoryEntry> getHistoryByCardType (CARD_TYPE cardType) {
		ArrayList<HistoryEntry> historySlice = new ArrayList<HistoryEntry>();
		this.history.forEach((historyEntry) -> {
			if (historyEntry.getCardType() == cardType) {
				historySlice.add(historyEntry);
			}
		});
		return historySlice;
	}

	private Card registerCard (Card card) {
		this.registeredCards.put(card.getId(), card);
		this.idForNextCard = card.getId() + 1;
		return card;
	}
}

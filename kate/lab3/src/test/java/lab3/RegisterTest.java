package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

import cardsMeta.CardsMeta;
import historyEntry.HISTORY_ENTRY_TYPE;
import historyEntry.HistoryEntry;

public class RegisterTest {
	private Register register;
	private CardsMeta cardsMeta;
	
	@BeforeEach
	void beforeEach () {
		this.register = new Register();
		this.cardsMeta = new CardsMeta(false, false);
	}
	
	@Test
	public void shouldMakeCardWithIncrementalId () {
		Card card1 = this.register.makeCardWithGrantedTrips(10, this.cardsMeta);
		Card card2 = this.register.makeCardWithGrantedTrips(10, this.cardsMeta);
		
		Assertions.assertEquals(card1.getId(), 1);
		Assertions.assertEquals(card2.getId(), 2);
	}
	
	@Test
	public void shouldGetCardFromRegister () {
		Card card = this.register.makePeriodicalCard(CARD_TYPE.PERIODICAL_MORNING, 1, this.cardsMeta);
		Card actualCard = this.register.getCardById(card.getId());

		Assertions.assertEquals(card, actualCard);
	}
	
	@Test
	public void shouldBlockCard () {
		Card card = this.register.makeCardWithGrantedTrips(10, this.cardsMeta);
		
		Boolean isValidBeforeBlocking = card.isValid();
		this.register.blockCardById(card.getId());
		Boolean isValidAfterBlocking = card.isValid();
		
		Assertions.assertEquals(isValidBeforeBlocking, true);
		Assertions.assertEquals(isValidAfterBlocking, false);
	}
	
	@Test
	public void shouldWriteHistoryRelatedToParticularCard () {
		Card card = register.makeCardWithGrantedTrips(1, this.cardsMeta);
		
		this.register.onCardPass(card);
		this.register.onCardReject(card);
		ArrayList<HistoryEntry> history = this.register.getHistoryByCardId(card.getId());
		
		Assertions.assertEquals(
				history.get(0).getType(), HISTORY_ENTRY_TYPE.PASS
		);
		Assertions.assertEquals(
				history.get(1).getType(), HISTORY_ENTRY_TYPE.REJECT
		);
	}

	@Test
	public void shouldWriteHistoryRelatedToCardTypes () {
		Card card1 = register.makeCardWithGrantedTrips(1, this.cardsMeta);
		Card card2 = register.makePeriodicalCard(CARD_TYPE.PERIODICAL_MORNING, 1, this.cardsMeta);

		this.register.onCardPass(card1);
		this.register.onCardPass(card2);
		ArrayList<HistoryEntry> history = this.register.getHistoryByCardType(CARD_TYPE.WITH_GRANTED_TRIPS);
		
		Assertions.assertEquals(history.size(), 1);
	}
	
	
	@Test public void shouldWriteHistoryRelatedToAllCardsType () {
		Card card1 = this.register.makeCardWithGrantedTrips(1, this.cardsMeta);
		Card card2 = this.register.makePeriodicalCard(CARD_TYPE.PERIODICAL_MORNING, 1, this.cardsMeta);

		this.register.onCardPass(card1);
		this.register.onCardPass(card2);
		ArrayList<HistoryEntry> history = this.register.getHistory();
		
		Assertions.assertEquals(history.size(), 2);
	}
}

package lab3;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardsMeta.CardsMeta;

class GateTest {
	private Gate gate;
	private Register spiedRegister;
	private GateSygnals spiedGateSygnals;
	private CardsMeta cardsMeta;
	
	@BeforeEach
	void beforeEach () {
		// Перед каждым тестом создаем "шпионов" для обоих параметров конструктора Gates
		// и сам инстанс турникета
		Register register = new Register();
		GateSygnals gateSygnals = new GateSygnals();
		this.spiedRegister = spy(register);
		this.spiedGateSygnals = spy(gateSygnals);
		this.gate = new Gate(this.spiedRegister, this.spiedGateSygnals);
		this.cardsMeta = new CardsMeta(false, false);
	}
	
	@Test
	void shouldRejectPassIfCardIsBlocked () {
		Card card = this.spiedRegister.makeCardWithGrantedTrips(1, this.cardsMeta);
		this.spiedRegister.blockCardById(card.getId());
		this.gate.onContact(card);
		
		verify(this.spiedRegister, times(1)).onCardReject(card);
	}

	@Test
	void shouldRejectPassIfNoTrips () {
		Card card = this.spiedRegister.makeCardWithGrantedTrips(1, this.cardsMeta);
		// Количество поездок перед контактом - 1
		this.gate.onContact(card);
		// Количество поездок перед контактом - 0. Доступ будет запрещен
		this.gate.onContact(card);
		
		verify(this.spiedRegister, times(1)).onCardReject(card);
	}
	
	@Test
	void shouldEmitWarnOnHandleDiscountedCard () {
		// Создаем карту, с VIP: false, isDiscounted: true
		CardsMeta discountedCardsMeta = new CardsMeta(false, true);
		Card card = this.spiedRegister.makeCardWithGrantedTrips(1, discountedCardsMeta);
		
		this.gate.onContact(card);
		
		// Подтверждаем, что был брошен сигнал от турникета
		verify(this.spiedGateSygnals, times(1)).emitWarn();
	}
}

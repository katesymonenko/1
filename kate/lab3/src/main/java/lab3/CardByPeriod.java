package lab3;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import cardsMeta.CardsMeta;

public class CardByPeriod extends AbstractCard implements Card {

	private long expirationDate;
	
	public CardByPeriod(int id, CardsMeta cardsMeta, CARD_TYPE cardType, int daysBeforeExpire) {
		super(id, cardsMeta, cardType);
		this.scheduleExpirationDateInDays(daysBeforeExpire);
	}

	public CardsMeta getCardsMeta(Card card) {
		return super.getCardsMeta();
	}
	
	public Boolean isValid () {
		return super.isValid() && !this.isExpired() && this.isInTimeRange();
	}
	
	public void use () {
		return;
	}
	
	private Boolean isInTimeRange () {
		int localHours = this.getLocalHours();
		switch (this.getCardType()) {
			case PERIODICAL_MORNING:
				return localHours >= 9 && localHours < 14;
			case PERIODICAL_EVENING:
				return localHours >= 14 && localHours < 19;
			case PERIODICAL_NIGHT:
			default:
				return localHours >= 19 && localHours <= 23;
		}
	}
	
	private long getExpirationDate () {
		return expirationDate;
	}
	
	private void setExpirationDate (long expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	private void scheduleExpirationDateInDays (int daysBeforeExpire) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, daysBeforeExpire);
		this.setExpirationDate(calendar.getTimeInMillis());
	}
	
	private Boolean isExpired () {
		return this.getExpirationDate() >= System.currentTimeMillis();
	}
	
	protected int getLocalHours () {
		LocalTime now = LocalTime.now();
		return now.getHour();
	}

}

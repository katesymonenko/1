package historyEntry;

import lab3.CARD_TYPE;

public class HistoryEntry {
	private HISTORY_ENTRY_TYPE type;
	private long accessTime;
	private int cardId;
	private CARD_TYPE cardType;
	
	public HistoryEntry(
		int cardId, 
		HISTORY_ENTRY_TYPE historyType,
		CARD_TYPE cardType
	) {
		this.cardId = cardId;
		this.type = historyType;
		this.accessTime = System.currentTimeMillis();
		this.cardType = cardType;
	}

	public HISTORY_ENTRY_TYPE getType() {
		return type;
	}

	public long getAccessTime() {
		return accessTime;
	}

	public int getCardId () {
		return this.cardId;
	}
	
	public CARD_TYPE getCardType () {
		return this.cardType;
	}
	
}

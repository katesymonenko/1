package cardsMeta;

public class CardsMeta {
	private Boolean isVIP;
	private Boolean isDiscounted;
	
	public CardsMeta(Boolean isVIP, Boolean isDiscounted) {
		this.setIsVIP(isVIP);
		this.setIsDiscounted(isDiscounted);
	}

	public Boolean getIsVIP() {
		return isVIP;
	}

	public void setIsVIP(Boolean isVIP) {
		this.isVIP = isVIP;
	}

	public Boolean getIsDiscounted() {
		return isDiscounted;
	}

	public void setIsDiscounted(Boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}

}

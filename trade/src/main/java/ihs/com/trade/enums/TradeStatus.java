package ihs.com.trade.enums;

public enum TradeStatus {

	ACTIVE("ACTIVE"),
	CANCELLED("CANCELLED");
	
	String value;
	
	private TradeStatus(String value) {
		this.value = value;
	}
}

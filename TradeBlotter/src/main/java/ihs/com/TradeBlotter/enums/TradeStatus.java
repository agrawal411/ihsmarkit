package ihs.com.TradeBlotter.enums;

public enum TradeStatus {

	ACTIVE("ACTIVE"),
	CANCELLED("CANCELLED");
	
	String value;
	
	private TradeStatus(String value) {
		this.value = value;
	}
}

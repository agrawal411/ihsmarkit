package ihs.com.trade.enums;

import lombok.Getter;

@Getter
public enum Side {

	BUY("BUY"),
	SELL("SELL");
	
	String value;

	private Side(String value) {
		this.value = value;
	}
}

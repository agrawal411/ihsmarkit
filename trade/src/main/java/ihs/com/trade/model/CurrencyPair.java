package ihs.com.trade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CURRENCY_PAIR")
public class CurrencyPair {
	
	@Column(name = "CURRENCY_PAIR_NAME")
	@Id
	String currencyPairName;
	Float rate;
	public String getCurrencyPairName() {
		return currencyPairName;
	}
	public void setCurrencyPairName(String currencyPairName) {
		this.currencyPairName = currencyPairName;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}

}

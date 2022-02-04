package ihs.com.trade.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import ihs.com.trade.enums.Side;
import ihs.com.trade.enums.TradeStatus;
import lombok.Data;

@Data
@Entity
@Table(name = "TRADE_CAPTURE")
@XmlRootElement(name ="trade")
public class TradeCapture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_sequence")
	@SequenceGenerator(name = "trade_sequence", sequenceName = "trade_sequence",
			allocationSize = 1)
	private Long tradeId;
	
	@Column(name = "COUNTER_PARTY")
	@NotNull(message = "counterParty can not be null")
	private String counterParty;
	
	@Column(name = "CURRENCY_PAIR")
	@NotNull(message = "currency pair can not be null")
	private String currencyPair;
	
	@Column(name = "RATE")
	@NotNull(message = "rate can not be null")
	private float rate;
	
	@Column(name = "SIDE")
	@NotNull(message = "side can not be null")
	private String side;
	
	@Column(name = "NOTIONAL")
	@NotNull(message = "notional can not be null")
	private BigDecimal notional;
	
	@Column(name = "VALUE_DATE")
	@NotNull(message = "value date can not be null")
	private Date valueDate;
	
	@NotNull(message = "userId can not be null")
	private Long userId;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name = "CANCEL_DATE")
	private Date cancelDate;
	
	@Column(name="USER_CANCELLED")
	private String userCancelled;

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public BigDecimal getNotional() {
		return notional;
	}

	public void setNotional(BigDecimal notional) {
		this.notional = notional;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getUserCancelled() {
		return userCancelled;
	}

	public void setUserCancelled(String userCancelled) {
		this.userCancelled = userCancelled;
	}
}

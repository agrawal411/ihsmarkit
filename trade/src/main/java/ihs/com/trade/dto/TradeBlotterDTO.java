package ihs.com.trade.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TradeBlotterDTO {
	
	private Long tradeId;
	private String counterParty;
	private String currencyPair;
	private float rate;
	private String side;
	private BigDecimal notional;
	private Date valueDate;
	private Long userId;
	private String status;
	private Date cancelDate;
	private String userCancelled;
	private float marketRate;
	private Double profitLoss;
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
	public float getMarketRate() {
		return marketRate;
	}
	public void setMarketRate(float marketRate) {
		this.marketRate = marketRate;
	}
	public Double getProfitLoss() {
		return profitLoss;
	}
	public void setProfitLoss(Double profitLoss) {
		this.profitLoss = profitLoss;
	}
	
	

}

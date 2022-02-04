package ihs.com.trade.mapper;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ihs.com.trade.dto.TradeBlotterDTO;
import ihs.com.trade.model.TradeCapture;
import ihs.com.trade.service.CurrencyPairService;

@Component
public class TradeBlotterDTOMapper {
	
	@Autowired
	private CurrencyPairService currencyPairService;
	

	public TradeBlotterDTO mapper(TradeCapture tradeCapture) {
		TradeBlotterDTO tradeBlotterDTO = new TradeBlotterDTO();
		tradeBlotterDTO.setCounterParty(tradeCapture.getCounterParty());
		tradeBlotterDTO.setCurrencyPair(tradeCapture.getCurrencyPair());
		tradeBlotterDTO.setNotional(tradeCapture.getNotional());
		tradeBlotterDTO.setRate(tradeCapture.getRate());
		tradeBlotterDTO.setSide(tradeCapture.getSide());
		tradeBlotterDTO.setStatus(tradeCapture.getStatus());
		tradeBlotterDTO.setTradeId(tradeCapture.getTradeId());
		tradeBlotterDTO.setUserCancelled(tradeCapture.getUserCancelled());
		tradeBlotterDTO.setUserId(tradeCapture.getUserId());
		tradeBlotterDTO.setValueDate(tradeCapture.getValueDate());
		tradeBlotterDTO.setCancelDate(tradeCapture.getCancelDate());
		tradeBlotterDTO.setMarketRate(getMarketRate(tradeCapture.getCurrencyPair()));
		tradeBlotterDTO.setProfitLoss(getProfitLoss(tradeCapture.getRate(), getMarketRate(tradeCapture.getCurrencyPair()), tradeCapture.getNotional()));
		
		return tradeBlotterDTO;
	}
	
	public float getMarketRate(String currencyPairName) {
		return currencyPairService.getCurrencyPairByName(currencyPairName).getRate();
	}
	
	public Double getProfitLoss(float rate, float marketRate, BigDecimal notional) {
		float actualRate = marketRate - rate;		
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(notional.doubleValue()*actualRate));
	}
}

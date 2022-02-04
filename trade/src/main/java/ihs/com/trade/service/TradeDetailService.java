package ihs.com.trade.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ihs.com.trade.model.TradeCapture;
import ihs.com.trade.repository.TradeRepository;

@Service
public class TradeDetailService {

	@Autowired
    private  TradeRepository tradeRepository;
	
	 private static final Logger logger = LoggerFactory.getLogger(TradeDetailService.class);
	 
	  
	  public TradeCapture saveTrade(TradeCapture tradeCapture) {
		  logger.info("Inside TradeDetailService........");
		  TradeCapture savedEntity = tradeRepository.save(tradeCapture);
		  
		  return savedEntity;
	  }
	  
	  public List<TradeCapture> getAllTrades() {
		  return (List<TradeCapture>) tradeRepository.findAll();
	  }
	  
	  public List<TradeCapture> getTradeByUserId(Long userId) {
		  return tradeRepository.findTradeCaptureByUserId(userId);
	  }
	  
	  public TradeCapture updateTrade(TradeCapture tradeCapture) {
		  TradeCapture updatedEntity = tradeRepository.save(tradeCapture);
		  
		  return updatedEntity;
	  }
	  
	  public TradeCapture getTradeByTradeId(Long tradeId) {
		  Optional<TradeCapture> trade = tradeRepository.findById(tradeId);
		  if(trade.isPresent()) {
			  return trade.get();
		  }
		  return null;
	  }
	  
	  public List<String> getCounterPartyNames(String input) {
		  return tradeRepository.findCounterPartyLike(input);
	  }
}


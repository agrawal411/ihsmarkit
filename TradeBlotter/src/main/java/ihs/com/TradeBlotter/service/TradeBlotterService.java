package ihs.com.TradeBlotter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ihs.com.TradeBlotter.model.TradeBlotter;
import ihs.com.TradeBlotter.repo.TradeBlotterRepository;
import ihs.com.TradeBlotter.util.SearchTrade;


@Service
public class TradeBlotterService {

	@Autowired
	TradeBlotterRepository tradeBlotterRepository;
	
	public TradeBlotter getTradeById(Long tradeId) {
		Optional<TradeBlotter> trade = tradeBlotterRepository.findById(tradeId);
		if(trade.isPresent()) {
		return trade.get();
		}else
			return null;
		
	}
	
	public List<TradeBlotter> getAllTrades() {
		return (List<TradeBlotter>) tradeBlotterRepository.findAll();
	}
	
	public List<TradeBlotter> getTradesByUserId(Long userId) {
		return tradeBlotterRepository.getTradeBlotterByUserId(userId);
	}
	
	public void saveUpdateTrade(TradeBlotter tradeBlotter) {
		tradeBlotterRepository.save(tradeBlotter);
	}
	
	public List<TradeBlotter> getTradesbySearchCriteria1(SearchTrade searchTrade) {
        if((!searchTrade.getCounterParty().isEmpty() )&& (!("select" ).equals(searchTrade.getCurrencyPair()))){
            return tradeBlotterRepository.findTradesbySearchCriteria(searchTrade.getCounterParty(), searchTrade.getCurrencyPair());
        }else if((searchTrade.getCounterParty().isEmpty() )&& (("select" ).equals(searchTrade.getCurrencyPair()))){
            return (List<TradeBlotter>) tradeBlotterRepository.findAll();
        }else if((searchTrade.getCounterParty().isEmpty() )){
            return tradeBlotterRepository.getTradeBlotterByCurrencyPair(searchTrade.getCurrencyPair());
 
        }else if ((("select" ).equals(searchTrade.getCurrencyPair()))) {
            return tradeBlotterRepository.getTradeBlotterByCounterParty(searchTrade.getCounterParty());
 
    }
        return null;

    }
    public List<TradeBlotter> getTradesbyUserSearchCriteria1(Long userId,SearchTrade searchTrade) {
        if((!searchTrade.getCounterParty().isEmpty() )&& (!("select" ).equals(searchTrade.getCurrencyPair()))){
            return tradeBlotterRepository.findTradesbyUserSearchCriteria(userId, searchTrade.getCounterParty(), searchTrade.getCurrencyPair());
        }else if((searchTrade.getCounterParty().isEmpty() )&& (("select" ).equals(searchTrade.getCurrencyPair()))){
            return tradeBlotterRepository.getTradeBlotterByUserId(userId);
        }else if((searchTrade.getCounterParty().isEmpty() )){
            return tradeBlotterRepository.getTradeBlotterByUserCurrencyPair(userId, searchTrade.getCurrencyPair());
        }else if ((("select" ).equals(searchTrade.getCurrencyPair()))) {
            return tradeBlotterRepository.getTradeBlotterByUserCounterParty(userId, searchTrade.getCounterParty());
    }
        return null;
        }
}

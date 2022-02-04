package ihs.com.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ihs.com.trade.model.CurrencyPair;
import ihs.com.trade.repository.CurrencyPairRepository;

@Service
public class CurrencyPairService {

	@Autowired
	private CurrencyPairRepository currencyPairRepository;
	
	public List<CurrencyPair> getCurrencyPairs() {
		return currencyPairRepository.findAll();
	}
	
	public CurrencyPair getCurrencyPairByName(String currencyPairName) {
		return currencyPairRepository.getCurrencyPairByCurrencyPairName(currencyPairName);
	}
	
	public CurrencyPair updateCurrencyPiar(CurrencyPair currencyPair) {
		return currencyPairRepository.save(currencyPair);
	}
}

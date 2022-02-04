package ihs.com.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ihs.com.trade.model.CurrencyPair;

@Repository
public interface CurrencyPairRepository extends CrudRepository<CurrencyPair, String> {

	List<CurrencyPair> findAll();
	
	CurrencyPair getCurrencyPairByCurrencyPairName(String currencyPairName);
}

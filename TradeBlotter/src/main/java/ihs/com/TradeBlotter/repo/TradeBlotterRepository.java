package ihs.com.TradeBlotter.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ihs.com.TradeBlotter.model.TradeBlotter;


@Repository
public interface TradeBlotterRepository extends CrudRepository<TradeBlotter, Long>{

	List<TradeBlotter> getTradeBlotterByUserId(Long userId);
	
	@Query("SELECT trade FROM TradeBlotter trade WHERE COUNTER_PARTY=:counterParty and CURRENCY_PAIR=:currencyPair")
    List<TradeBlotter> findTradesbySearchCriteria(@Param("counterParty") String counterParty,@Param("currencyPair") String currencyPair);
     //@Query("SELECT trade FROM TradeBlotter trade WHERE  USER_ID=:userId AND (counterParty is null and currencyPair is null) or (COUNTER_PARTY=:counterParty or CURRENCY_PAIR=:currencyPair))")
     @Query("SELECT trade FROM TradeBlotter trade WHERE USER_ID=:userId AND COUNTER_PARTY=:counterParty AND CURRENCY_PAIR=:currencyPair")
     List<TradeBlotter> findTradesbyUserSearchCriteria(@Param("userId")Long userId,@Param("counterParty")String counterParty,@Param("currencyPair")String currencyPair);
     
     @Query("SELECT trade FROM TradeBlotter trade WHERE  COUNTER_PARTY=:counterParty")
     List<TradeBlotter> getTradeBlotterByCounterParty(@Param("counterParty")String counterParty);

      @Query("SELECT trade FROM TradeBlotter trade WHERE  CURRENCY_PAIR=:currencyPair")
         List<TradeBlotter> getTradeBlotterByCurrencyPair(@Param("currencyPair")String currencyPair);

      @Query("SELECT trade FROM TradeBlotter trade WHERE USER_ID=:userId AND COUNTER_PARTY=:counterParty")
      List<TradeBlotter> getTradeBlotterByUserCounterParty(@Param("userId")Long userId,@Param("counterParty")String counterParty);

      @Query("SELECT trade FROM TradeBlotter trade WHERE USER_ID=:userId AND CURRENCY_PAIR=:currencyPair")
     List<TradeBlotter> getTradeBlotterByUserCurrencyPair(@Param("userId")Long userId,@Param("currencyPair")String currencyPair);
}

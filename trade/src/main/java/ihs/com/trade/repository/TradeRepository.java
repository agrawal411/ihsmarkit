package ihs.com.trade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ihs.com.trade.model.TradeCapture;

public interface TradeRepository extends CrudRepository<TradeCapture, Long> {
	
	
	List<TradeCapture> findTradeCaptureByUserId(Long userId); 
	
	Optional<TradeCapture> findById(Long tradeId);
	
	@Query("select counterParty from TradeCapture where counterParty like %:input%")
	List<String> findCounterPartyLike(@Param("input") String input);
}

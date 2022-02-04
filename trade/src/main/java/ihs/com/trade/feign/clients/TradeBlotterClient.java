package ihs.com.trade.feign.clients;

import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ihs.com.trade.dto.SearchTrade;
import ihs.com.trade.model.TradeCapture;

@FeignClient(name = "tradeBlotter", url = "http://localhost:8083")
public interface TradeBlotterClient {

	@LoadBalanced
	@RequestMapping(method = RequestMethod.GET, value = "/trade-blotter/{userRole}")
	List<TradeCapture> getTradeList(@PathVariable("userRole")String userRole,@RequestParam("userId") Long userId);
	
	@LoadBalanced
    @RequestMapping(method = RequestMethod.POST, value = "/search-trade/{userRole}")
    List<TradeCapture> searchTradeList1(@PathVariable("userRole")String userRole,@RequestBody SearchTrade searchTrade,@RequestParam("userId")Long userId );
}

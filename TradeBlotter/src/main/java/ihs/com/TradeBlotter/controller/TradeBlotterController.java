package ihs.com.TradeBlotter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ihs.com.TradeBlotter.model.TradeBlotter;
import ihs.com.TradeBlotter.service.TradeBlotterService;
import ihs.com.TradeBlotter.util.SearchTrade;

@RestController
@RequestMapping
public class TradeBlotterController {
	/*@Autowired
	private TradeDetailService tradeDetailService;*/
	@Autowired
	private TradeBlotterService tradeBlotterService;
	
	@GetMapping("/trade-blotter/{userRole}")
    public List<TradeBlotter> getAllUserSpecificTrade(@PathVariable("userRole") String userRole, @RequestParam Long userId){
		
		if(userRole.equals("admin")) {
			return tradeBlotterService.getAllTrades();
		}
		else if(userRole.equals("user")) {
			return tradeBlotterService.getTradesByUserId(userId);
		}
		else {
			return null;
		}
		
		/*User u = (User)model.getAttribute("user");
		if(u == null) {
			return "error";
		}*/
		//List<TradeBlotter> trades = tradeDetailService.getTradeByUserId(u.getUserId());
		//return trades;
		/*if(trades != null) {
			model.addAttribute("trades", trades);
			
		}else {
			
			return "error" ;
		}
		  //convert savedEntity to excel and push to queue
		  return "tradeBlotter";*/
    }
	@RequestMapping(value="/modify-trade", method = RequestMethod.GET)
    public String modifyTrade(@RequestParam("tradeId") Long tradeId, Model model){
		TradeBlotter tradeBlotter=tradeBlotterService.getTradeById(tradeId);
		model.addAttribute("tradeBlotter", tradeBlotter);
		return "updateTrade";
	}

	/*@RequestMapping(value="/update-capture", method = RequestMethod.POST)
    public String saveTrade(@ModelAttribute("tradeBlotter") TradeBlotter tradeBlotter, Model model){
		
		tradeBlotter.setUserId(u.getUserId());
		tradeBlotter.setStatus(TradeStatus.ACTIVE);
		tradeBlotter.setProfitLoss(getProfitLoss(tradeCapture));
		TradeCapture savedEntity = tradeDetailService.saveTrade(tradeCapture);
		if(savedEntity != null) {
			model.addAttribute("message", "Trade Added successfully");
			model.addAttribute("tradeCapture", new TradeCapture());
    		model.addAttribute("currencyPairs", currencyPairService.getCurrencyPairs());
    		model.addAttribute("sides", Side.values());
    		String xml=Utility.convertObjToXMl(savedEntity);
    		 publisher.push(xml);
		}
		  //convert savedEntity to excel and push to queue
		  return "tradeCapture";
    }*/
	
	@PostMapping("/search-trade/{userRole}")
    public List<TradeBlotter> searchTrade1( @PathVariable("userRole")String userRole,@RequestBody SearchTrade searchTrade,@RequestParam("userId")Long userId ){
        if(userRole.equals("admin")) {
            return tradeBlotterService.getTradesbySearchCriteria1(searchTrade);
        }
        else if(userRole.equals("user")) {
            return tradeBlotterService.getTradesbyUserSearchCriteria1(userId,searchTrade);
        }
        else {
            return null;
        }
    }
}

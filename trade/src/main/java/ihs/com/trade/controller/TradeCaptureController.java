package ihs.com.trade.controller;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.trade.util.Utility;

import ihs.com.trade.Publisher;
import ihs.com.trade.dto.SearchTrade;
import ihs.com.trade.enums.Side;
import ihs.com.trade.enums.TradeStatus;
import ihs.com.trade.model.CurrencyPair;
import ihs.com.trade.model.TradeCapture;
import ihs.com.trade.model.User;
import ihs.com.trade.service.CurrencyPairService;
import ihs.com.trade.service.TradeDetailService;

@Controller
@SessionAttributes(names = {"user"})
public class TradeCaptureController {
	
	@Autowired
	private TradeDetailService tradeDetailService;
	
	@Autowired
	private CurrencyPairService currencyPairService;
	
	@Autowired
	Publisher publisher;
	
	@Autowired
	private TradeBlotterController tradeBlotterController;
	
	@RequestMapping(value="/trade-capture", method = RequestMethod.POST)
    public String saveTrade(@ModelAttribute("tradeCapture") TradeCapture tradeCapture, Model model){
		User u = (User)model.getAttribute("user");
		if(u == null) {
			return "error";
		}
		tradeCapture.setUserId(u.getUserId());
		tradeCapture.setStatus(TradeStatus.ACTIVE.name());
		TradeCapture savedEntity = tradeDetailService.saveTrade(tradeCapture);
		if(savedEntity != null) {
			model.addAttribute("message", "Trade Booked successfully, Id : "+savedEntity.getTradeId());
			model.addAttribute("tradeCapture", new TradeCapture());
    		model.addAttribute("currencyPairs", currencyPairService.getCurrencyPairs());
    		model.addAttribute("sides", Side.values());
    		String xml=Utility.convertObjToXMl(savedEntity);
    		 publisher.push(xml);
		}
		  //convert savedEntity to excel and push to queue
		  return "tradeCapture";
    }
	
	@RequestMapping(value="/trade-capture", method = RequestMethod.GET)
    public String redirectTradeCapture(Model model){
		User u = (User)model.getAttribute("user");
		if(u == null) {
			return "error";
		}
		
		//model.addAttribute("message", "Trade Booked successfully, Id : "+savedEntity.getTradeId());
		model.addAttribute("tradeCapture", new TradeCapture());
		model.addAttribute("currencyPairs", currencyPairService.getCurrencyPairs());
		model.addAttribute("sides", Side.values());
		//String xml=Utility.convertObjToXMl(savedEntity);
		// publisher.push(xml);
		
		  //convert savedEntity to excel and push to queue
		  return "tradeCapture";
    }
	
	
	@RequestMapping(value="/update-trade/{tradeId}", method = RequestMethod.GET)
    public String updateTrade(@PathVariable Long tradeId, Model model){
		model.addAttribute("currencyPairs", currencyPairService.getCurrencyPairs());
		model.addAttribute("sides", Side.values());
		model.addAttribute("tradeBlotter", tradeDetailService.getTradeByTradeId(tradeId));
		
		return "updateTrade";
		
	}
	
	@RequestMapping(value="/cancel-trade/{tradeId}", method = RequestMethod.GET)
    public String cancelTrade(@PathVariable Long tradeId, Model model){
		User u = (User) model.getAttribute("user");
		TradeCapture trade = tradeDetailService.getTradeByTradeId(tradeId);
		trade.setStatus(TradeStatus.CANCELLED.name());
		trade.setCancelDate(new Date());
		trade.setUserCancelled(u.getUsername());
		TradeCapture updatedEntity = tradeDetailService.updateTrade(trade);
		String xml=Utility.convertObjToXMl(updatedEntity);
		 publisher.push(xml);
		 model.addAttribute("userRole", u.getRole());
		 return tradeBlotterController.getAllUserSpecificTrade(model);
		
	}
	
	@RequestMapping(value="/update-trade-capture", method = RequestMethod.POST)
	public String updateTradeCapture(@ModelAttribute("tradeCapture") TradeCapture tradeCapture, Model model) {
		TradeCapture updatedEntity = tradeDetailService.updateTrade(tradeCapture);
		String xml=Utility.convertObjToXMl(updatedEntity);
		 publisher.push(xml);
		 return tradeBlotterController.getAllUserSpecificTrade(model);
	}
	
	@RequestMapping(value="/update-rate", method = RequestMethod.GET)
	public String updateRate(Model model) {
		model.addAttribute("CurrencyPairs", currencyPairService.getCurrencyPairs());
		model.addAttribute("CurrencyPair", new CurrencyPair());
		return "updateRate";
	}
	
	@RequestMapping(value="/update-market-rate", method = RequestMethod.POST)
	public String updateMarketRate(@ModelAttribute("CurrencyPair") CurrencyPair currencyPair, Model model) {
		DecimalFormat df = new DecimalFormat("0.00");
		currencyPair.setRate(Float.valueOf(df.format(currencyPair.getRate())));
		currencyPairService.updateCurrencyPiar(currencyPair);
		return tradeBlotterController.getAllUserSpecificTrade(model);
	}
	
	@RequestMapping(value = "/counter-party", method = RequestMethod.GET) 
	@ResponseBody
	public List<String> getCounterParties(@RequestParam("term") String term){
		return tradeDetailService.getCounterPartyNames(term);
	}
}

package ihs.com.trade.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ihs.com.trade.dto.SearchTrade;
import ihs.com.trade.feign.clients.TradeBlotterClient;
import ihs.com.trade.mapper.TradeBlotterDTOMapper;
import ihs.com.trade.model.TradeCapture;
import ihs.com.trade.model.User;
import ihs.com.trade.service.CurrencyPairService;

@Controller
@SessionAttributes(names = {"user"})
public class TradeBlotterController {
	
	@Autowired
	private TradeBlotterClient tradeBlotterClient;
	
	@Autowired
	private TradeBlotterDTOMapper tradeBlotterDTOMapper;
	
	@Autowired
	private CurrencyPairService currencyPairService;
	
	@RequestMapping(value="/trade-blotter", method = RequestMethod.GET)
    public String getAllUserSpecificTrade(/*@ModelAttribute("tradeBlotter") TradeCapture tradeCapture,*/ Model model){
		User u = (User)model.getAttribute("user");
		List<TradeCapture> tradeList = new ArrayList<>();
		if(u == null) {
			return "error";
		}
		else {
			/*if(u.getRole().equals("user")) {
				tradeList = tradeBlotterClient.getTradeList(u.getRole(), u.getUserId());
			}*/
			//else if(u.getRole().equals("admin")) {
				tradeList = tradeBlotterClient.getTradeList(u.getRole(), u.getUserId());
			//}
			model.addAttribute("trades", tradeList.stream().map(tradeBlotterDTOMapper::mapper).collect(Collectors.toList()));
			model.addAttribute("userRole", u.getRole());
			model.addAttribute("currencyPairs", currencyPairService.getCurrencyPairs());
			model.addAttribute("searchTrade", new SearchTrade());
		}
	  return "tradeBlotter";
    }
	
	@RequestMapping(value="/search-trade", method = RequestMethod.POST)
    public String searchTrade1(@ModelAttribute("searchTrade") SearchTrade searchTrade,Model model){
        User u = (User)model.getAttribute("user");
        List<TradeCapture> tradeList = new ArrayList<>();
        if(u == null) {
            return "error";
        }else {
            if(u.getRole().equals("user")) {
                tradeList = tradeBlotterClient.searchTradeList1(u.getRole(),searchTrade,u.getUserId());
            }
            else if(u.getRole().equals("admin")) {
                tradeList = tradeBlotterClient.searchTradeList1(u.getRole(), searchTrade,u.getUserId());
            }
            model.addAttribute("trades", tradeList.stream().map(tradeBlotterDTOMapper::mapper).collect(Collectors.toList()));
            model.addAttribute("currencyPairs", currencyPairService.getCurrencyPairs());
			model.addAttribute("searchTrade", new SearchTrade());
			model.addAttribute("userRole", u.getRole());
        }
        return "tradeBlotter";
    }
}

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
import ihs.com.trade.enums.Side;
import ihs.com.trade.feign.clients.TradeBlotterClient;
import ihs.com.trade.mapper.TradeBlotterDTOMapper;
import ihs.com.trade.model.TradeCapture;
import ihs.com.trade.model.User;
import ihs.com.trade.service.CurrencyPairService;
import ihs.com.trade.service.LoginService;
import ihs.com.trade.service.TradeDetailService;

@Controller
@SessionAttributes(names = {"user"})
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @Autowired
    private CurrencyPairService currencyPairService;
    
    @Autowired
    private TradeDetailService tradeDetailService;
    
    @Autowired
    private TradeBlotterClient tradeBlotterClient;
    
    @Autowired
    private TradeBlotterDTOMapper tradeBlotterDTOMapper;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(Model model){
        model.addAttribute("user", new User());
    	return "Login";
    }
//
    @RequestMapping(value="/login", method = RequestMethod.POST)
    //public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
    public String showWelcomePage(@ModelAttribute("user") User user, Model model){
        User repoUser = loginService.validateUser(user);
    	if(repoUser != null) {
    		// validate role and redirect
    		if(repoUser.getRole().equals("user")) {
	    		model.addAttribute("tradeCapture", new TradeCapture());
	    		model.addAttribute("currencyPairs", currencyPairService.getCurrencyPairs());
	    		model.addAttribute("sides", Side.values());
	    		model.addAttribute("user", repoUser);
	    		return "tradeCapture";
    		}
    		else {
    			List<TradeCapture> tradeList = new ArrayList<TradeCapture>();
    			tradeList = tradeBlotterClient.getTradeList(repoUser.getRole(), repoUser.getUserId());
    			model.addAttribute("trades", tradeList.stream().map(tradeBlotterDTOMapper::mapper).collect(Collectors.toList()));
    			model.addAttribute("user", repoUser);
    			model.addAttribute("userRole", repoUser.getRole());
    			model.addAttribute("currencyPairs", currencyPairService.getCurrencyPairs());
    			model.addAttribute("searchTrade", new SearchTrade());
    			return "tradeBlotter";
    		}
    	}
    	else {
    		model.addAttribute("errorMessage", "Wrong Id and Password");
    		return "Login";
    	}
    }
}

package ihs.com.TradeBlotter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
 
import ihs.com.TradeBlotter.model.TradeBlotter;
import ihs.com.TradeBlotter.service.TradeBlotterService;
import ihs.com.TradeBlotter.util.Utility;
 
@Component
public class Listener {
	
	@Autowired
	private TradeBlotterService tradeBlotterService;
	
     @JmsListener(destination = "tradeQueue")
        public void receiveConfirmation(String message) {
           System.out.println("  Received confirmation: " + message);
        TradeBlotter tradeBlotter=   Utility.convertXMlToObj(message);
        tradeBlotterService.saveUpdateTrade(tradeBlotter);
        
        System.out.println("tradeCapture obj in listener"+tradeBlotter.getCounterParty());
        }
}
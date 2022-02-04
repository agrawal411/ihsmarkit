package ihs.com.TradeBlotter.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import ihs.com.TradeBlotter.model.TradeBlotter;

@Component
public class Utility {

	public static TradeBlotter convertXMlToObj(String  message) {
        TradeBlotter tradeBlotter = null;
        try {
            StringReader sr = new StringReader(message);
            JAXBContext jaxbContext = JAXBContext.newInstance(TradeBlotter.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            tradeBlotter= (TradeBlotter) unmarshaller.unmarshal(sr);
            System.out.println("tradeCapture obj after conversion"+tradeBlotter.getCounterParty());
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return tradeBlotter;
    }
}

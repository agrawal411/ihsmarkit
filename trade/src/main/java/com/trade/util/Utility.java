package com.trade.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ihs.com.trade.model.TradeCapture;

@Component
public class Utility {

	/*@Autowired
	private Jaxb2Marshaller marshaller;*/
	public static String convertObjToXMl(TradeCapture tradecapture) {
		StringWriter sw = new StringWriter();
		try {
		    JAXBContext context = JAXBContext.newInstance(TradeCapture.class);
		    Marshaller marshaller = context.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    marshaller.marshal(tradecapture, sw);
		//    System.out.println(sw.toString());
		} catch (JAXBException ex) {
		    ex.printStackTrace();
		}
		return sw.toString();
	}
	public static TradeCapture convertXMlToObj(String  message) {
		TradeCapture tradeCapture = null;
		try {
			StringReader sr = new StringReader(message);
			JAXBContext jaxbContext = JAXBContext.newInstance(TradeCapture.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			tradeCapture = (TradeCapture) unmarshaller.unmarshal(sr);
			System.out.println("tradeCapture obj after conversion"+tradeCapture.getCounterParty());
		} catch (JAXBException ex) {
		    ex.printStackTrace();
		}
		return tradeCapture;
	}
	
	public static String formatDate(Date date) {
		SimpleDateFormat sd = new SimpleDateFormat("YYYY-mm-DD");
		return sd.format(date);
	}
}

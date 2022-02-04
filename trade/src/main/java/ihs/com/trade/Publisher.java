package ihs.com.trade;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class Publisher {
	@Autowired
	JmsTemplate jms;

	@Autowired
	ApplicationContext context;
	public void push(String message) {
	//	JmsTemplate j=context.getBean(JmsTemplate.class);
		jms.convertAndSend("tradeQueue",message);
	}
	/*@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(final String queueName, final String message) {
		Map map = new Gson().fromJson(message, Map.class);
		final String textMessage = "Hello" + map.get("name");
		System.out.println("Sending message " + textMessage + "to queue - " + queueName);
		jmsTemplate.send(queueName, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
				return message;
			}
		});
	}*/

}

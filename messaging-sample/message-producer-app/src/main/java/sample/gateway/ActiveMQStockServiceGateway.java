package sample.gateway;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import sample.domain.TradeRequest;

public class ActiveMQStockServiceGateway implements StockServiceGateway {

	private JmsTemplate jmsTemplate;

	public void send(final TradeRequest tradeRequest) {
		jmsTemplate.send("app.request.stock", new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
				message.setStringProperty("ticker", tradeRequest.getTicker());
				message.acknowledge();
				return message;
			}

		});
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

}

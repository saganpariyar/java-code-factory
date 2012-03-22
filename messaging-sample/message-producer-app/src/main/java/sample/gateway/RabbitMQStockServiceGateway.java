package sample.gateway;

import org.springframework.amqp.core.AmqpTemplate;

import sample.domain.TradeRequest;

public class RabbitMQStockServiceGateway implements StockServiceGateway {

	private AmqpTemplate amqpTemplate;

	public void send(final TradeRequest tradeRequest) {
		amqpTemplate.convertAndSend(tradeRequest);
	}

	public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

}

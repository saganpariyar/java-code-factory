package sample.gateway;

import sample.domain.TradeRequest;

/**
 * Gateway interface that sends trades to an external process.
 * 
 * @author Mark Pollack
 */
public interface StockServiceGateway {

	void send(TradeRequest tradeRequest);

}

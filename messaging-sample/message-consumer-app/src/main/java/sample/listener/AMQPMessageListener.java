package sample.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sample.domain.TradeRequest;
import sample.domain.TradeRequestDao;

public class AMQPMessageListener {

	private static Log logger = LogFactory.getLog(AMQPMessageListener.class);

	public void onTradeRequest(TradeRequest tradeRequest) {

		logger.info("Client received: " + tradeRequest);
		tradeRequest.setDescription("AFTER-RECEIVING");

		try {
			new TradeRequestDao().save(tradeRequest);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

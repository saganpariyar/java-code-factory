package sample.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import sample.domain.TradeRequest;
import sample.domain.TradeRequestDao;

/**
 * @author Dave Syer
 * 
 */
@Controller
public class JMSMessageListener implements MessageListener {

	private static Log logger = LogFactory.getLog(JMSMessageListener.class);

	public void onMessage(Message message) {
		logger.info("Client received: " + message);
		TradeRequest tradeRequest = new TradeRequest();
		try {
			tradeRequest.setTicker(message.getStringProperty("ticker"));
			tradeRequest.setDescription("AFTER-RECEIVING");
		}
		catch (JMSException e1) {
			e1.printStackTrace();
		}

		try {
			new TradeRequestDao().save(tradeRequest);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

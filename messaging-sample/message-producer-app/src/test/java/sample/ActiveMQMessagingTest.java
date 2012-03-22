package sample;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sample.domain.TradeRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:server-config-jms.xml" })
public class ActiveMQMessagingTest {

	@Autowired
	private JMSMessageProducer messageProducer;

	@Test
	public void test() throws Exception {
		TradeRequest tradeRequest = new TradeRequest();
		tradeRequest.setTicker("GOOG@" + Calendar.getInstance().getTime().toString());
		messageProducer.persistAndSendMessage(tradeRequest);
	}

}

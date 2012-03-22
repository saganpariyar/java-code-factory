package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "classpath: client-config-jms.xml" })
public class BootstrapListeners {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("client-config-jms.xml", "client-config-amqp.xml");

		while (true) {
			System.out.println("Listening...");
		}

	}

}

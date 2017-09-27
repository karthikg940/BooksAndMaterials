package com.virtusa.consumerapp;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RecevingNotification {
	
	public RecevingNotification()
	{
		
	}

	public void receiveEmailNotification() {
		try {
			Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			InitialContext context = new InitialContext();
			QueueConnectionFactory connFact = (QueueConnectionFactory) context
					.lookup("remoteConsumerConnectionFactory");
			Queue queue = (Queue) context.lookup("ReqQueue");
			QueueConnection conn = connFact.createQueueConnection();
			conn.start();
			QueueSession sess = conn.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			QueueReceiver receiver = sess.createReceiver(queue);
			TextMessage msg = (TextMessage) receiver.receive();
			System.out.println("after in to receive()");
			System.out.println("message is" + msg.getText());

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
 

}

package com.virtusa.firstapp.service;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RecevingNotification {

	public static void receiveEmailNotification() {
		try {

			Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			InitialContext context = new InitialContext();
			QueueConnectionFactory connFact = (QueueConnectionFactory) context
					.lookup("remoteConsumerConnectionFactory");
			Queue queue = (Queue) context.lookup("ReqQueue");
			QueueConnection conn = connFact.createQueueConnection();
			QueueSession sess = conn.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			QueueReceiver receiver = sess.createReceiver(queue);
			conn.start();
			receiver.setMessageListener(new MsgListener());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		receiveEmailNotification();
	}

}

class MsgListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("after in to receive()");
		try {
			if (TextMessage.class.isAssignableFrom(message.getClass())) {
				TextMessage textMessage = (TextMessage) message;
				System.out.println("message is" + textMessage.getText());
			} else if (ObjectMessage.class.isAssignableFrom(message.getClass())) {
				ObjectMessage objMessage = (ObjectMessage) message;
				System.out.println("message is"
						+ objMessage.getObject());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
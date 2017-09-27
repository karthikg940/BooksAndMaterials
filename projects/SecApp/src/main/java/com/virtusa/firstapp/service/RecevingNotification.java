package com.virtusa.firstapp.service;

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
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.virtusa.firstapp.bean.User;

	public class RecevingNotification {

		public static void receiveEmailNotification() {
			try {
				InitialContext context = new InitialContext();
				QueueConnectionFactory connFact = (QueueConnectionFactory) context
						.lookup("remoteConsumerConnectionFactory");
				Queue queue = (Queue) context.lookup("ReqQueue");
				QueueConnection conn = connFact.createQueueConnection();
				conn.start();
				QueueSession sess = conn.createQueueSession(false,
						Session.AUTO_ACKNOWLEDGE);
				QueueReceiver receiver=sess.createReceiver(queue);
				TextMessage msg= (TextMessage) receiver.receive();
				System.out.println("after in to receive()");
				System.out.println("message is"+msg.getText());
				
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



package com.virtusa.firstapp.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.virtusa.firstapp.bean.User;

public class EmailNotificationService {

	public static void sendEmailNotification(User user) {
		try {
			InitialContext context = new InitialContext();
			QueueConnectionFactory connFact = (QueueConnectionFactory) context
					.lookup("remotePublisherConnectionFactory");
			Queue queue = (Queue) context.lookup("ReqQueue");
			QueueConnection conn = connFact.createQueueConnection();
			QueueSession sess = conn.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = sess.createSender(queue);
			/*ObjectMessage  msg = sess.createObjectMessage();
			msg.setObject(user);*/
			TextMessage msg=sess.createTextMessage();
			msg.setText("Hello World1!!");
			sender.send(msg);
			System.out.println(msg);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		sendEmailNotification(null);
	}

}

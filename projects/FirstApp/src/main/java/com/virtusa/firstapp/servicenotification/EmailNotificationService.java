package com.virtusa.firstapp.servicenotification;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.stereotype.Service;

import com.virtusa.firstapp.bean.User;

@Service
public class EmailNotificationService {

	public static void sendEmailNotification() {
		try {

			Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			InitialContext context = new InitialContext(props);

			QueueConnectionFactory connFact = (QueueConnectionFactory) context
					.lookup("remotePublisherConnectionFactory");
			Queue queue = (Queue) context.lookup("ReqQueue");
			QueueConnection conn = connFact.createQueueConnection();
			QueueSession sess = conn.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = sess.createSender(queue);	
			  TextMessage msg=sess.createTextMessage();
			  msg.setText("Hello World1 34!!");
			 
			sender.send(msg);
			System.out.println(msg);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
	

	public static void main(String[] args) {
		sendEmailNotification();
	}


}

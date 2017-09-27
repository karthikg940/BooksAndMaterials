package com.virtusa.vhub.consumer1;

import java.io.StringWriter;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.virtusa.vhub.entity.Receive;

public class CommandSender {

	/*
	 * ActiveMQConnectionFactory AMQconnectionFactory;
	 * 
	 * 
	 * public ActiveMQConnectionFactory getAMQconnectionFactory() { return
	 * AMQconnectionFactory; }
	 * 
	 * public void setAMQconnectionFactory( ActiveMQConnectionFactory
	 * aMQconnectionFactory) { AMQconnectionFactory = aMQconnectionFactory; }
	 */

	// CommandMessages commandMessage;
	ActiveMQConnectionFactory connectionFactory;
	QueueConnection queueConnection;
	QueueSession queueSession;

	public void initialSender(CommandMessages commandmsg) {
		try {
			connectionFactory = new ActiveMQConnectionFactory("karaf", "karaf",
					"tcp://localhost:61616");
			queueConnection = connectionFactory.createQueueConnection();

			try {
				queueSession = queueConnection.createQueueSession(false,
						Session.AUTO_ACKNOWLEDGE);
				Queue queue = (Queue) commandmsg.getReplyTo();
				QueueSender queueSender = queueSession.createSender(queue);
				Receive response = new Receive();
				response.setStatus("received");
				response.setStatusCode("200");
				response.setStatusDescription("initial response");
				StringWriter writer = new StringWriter();
				JAXBContext context = JAXBContext.newInstance(Receive.class);
				context.createMarshaller().marshal(response, writer);
				TextMessage textMessage = queueSession.createTextMessage();
				textMessage.setJMSCorrelationID(commandmsg.getCorelationId());
				textMessage.setText(writer.toString());
				queueSender.send(textMessage);
				finalSender(commandmsg);

			} finally {
				queueConnection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void finalSender(CommandMessages commandmsg) {
		System.out.println("in the final sender method");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println("before activemq");
			QueueSession queueSession = queueConnection.createQueueSession(
					false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) commandmsg.getReplyTo();
			QueueSender queueSender = queueSession.createSender(queue);

			Receive response = new Receive();
			response.setStatus("received");
			response.setStatusCode("201");
			response.setStatusDescription("final response");
			StringWriter writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Receive.class);
			context.createMarshaller().marshal(response, writer);

			TextMessage textMessage = queueSession.createTextMessage();
			textMessage.setJMSCorrelationID(commandmsg.getCorelationId());
			textMessage.setStringProperty("CommandCallbackUrl",
					commandmsg.getCommandCallbackUrl());
			textMessage.setStringProperty("AckType", "FINAL");
			textMessage.setText(writer.toString());
			queueSender.send(textMessage);
			System.out.println("before send method last");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.virtusa.vhub.consumer2;

import java.io.StringWriter;
import java.util.Collections;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.virtusa.vhub.entity.Receive;
import com.virtusa.vhub.entity.ResponseList;

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
				ResponseList responseEntity=new ResponseList();
				response.setStatus("received");
				response.setStatusCode("202");
				response.setStatusDescription("initial response-2");
				responseEntity.setResponseList(Collections.singletonList(response));
 				StringWriter writer = new StringWriter();
				JAXBContext context = JAXBContext.newInstance(ResponseList.class);
				context.createMarshaller().marshal(responseEntity, writer);
				TextMessage textMessage = queueSession.createTextMessage();
				textMessage.setJMSCorrelationID(commandmsg.getCorelationId());
				textMessage.setText(writer.toString());
				queueSender.send(textMessage);
				System.out.println("after send method/////////////////");
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
			response.setStatusCode("202");
			response.setStatusDescription("final response-2");
			ResponseList responseEntity=new ResponseList();
			responseEntity.setResponseList(Collections.singletonList(response));
			StringWriter writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(ResponseList.class);
			context.createMarshaller().marshal(responseEntity, writer);
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
